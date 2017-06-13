package org.kajip.sample.datasource;

import org.kajip.sample.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("db")
public class UserRepositoryDb implements UserRepository {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate  jdbcTemplate;

    @Override
    @Transactional
    public void regist() {
        jdbcTemplate.query("SELECT 1", rs -> {
            logger.info("result: {}", rs.getInt(1));
        });
    }
}
