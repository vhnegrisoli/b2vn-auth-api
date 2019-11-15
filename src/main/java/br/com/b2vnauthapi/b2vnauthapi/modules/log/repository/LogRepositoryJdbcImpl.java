package br.com.b2vnauthapi.b2vnauthapi.modules.log.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepositoryJdbcImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void atualizaCamposDeDataEHora() {
        jdbcTemplate.update("SET lc_time TO 'pt_BR.UTF-8';");
        jdbcTemplate.update("call UPDATE_DATE_COLUMNS();");
    }
}