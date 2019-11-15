package br.com.b2vnauthapi.b2vnauthapi.modules.log.repository;

import br.com.b2vnauthapi.b2vnauthapi.modules.log.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepository extends JpaRepository<Log, Integer>, LogRepositoryCustom {

    List<Log> findByDataAcessoLessThanEqual(LocalDateTime dataAcessoDoisMesesAtras);
}
