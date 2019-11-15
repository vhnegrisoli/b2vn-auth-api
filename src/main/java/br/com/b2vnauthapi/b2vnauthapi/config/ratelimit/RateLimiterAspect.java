package br.com.b2vnauthapi.b2vnauthapi.config.ratelimit;

import br.com.b2vnauthapi.b2vnauthapi.exceptions.ratelimit.LimitRateException;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Aspect
@Component
public class RateLimiterAspect {

    public interface KeyFactory {
        String createKey(JoinPoint jp, RateLimit limit);
    }

    private static final KeyFactory DEFAULT_KEY_FACTORY = (jp, limit) -> JoinPointToStringHelper.toString(jp);

    private final ConcurrentHashMap<String, RateLimiter> limiters;

    private final KeyFactory keyFactory;

    @Autowired
    public RateLimiterAspect(Optional<KeyFactory> keyFactory) {
        this.limiters = new ConcurrentHashMap<>();
        this.keyFactory = keyFactory.orElse(DEFAULT_KEY_FACTORY);
    }

    @Before("@annotation(limit)")
    public void rateLimit(JoinPoint jp, RateLimit limit) {
        String key = createKey(jp, limit);
        RateLimiter limiter = limiters.computeIfAbsent(key, createLimiter(limit));
        var aquire = limiter.tryAcquire(0, TimeUnit.SECONDS);
        if (!aquire) {
            throw new LimitRateException("Você fez muitas solicitações, aguarde.");
        }
    }

    private Function<String, RateLimiter> createLimiter(RateLimit limit) {
        return name -> RateLimiter.create(limit.value());
    }

    private String createKey(JoinPoint jp, RateLimit limit) {
        return Optional.ofNullable(Strings.emptyToNull(limit.key()))
            .orElseGet(() -> keyFactory.createKey(jp, limit));
    }
}
