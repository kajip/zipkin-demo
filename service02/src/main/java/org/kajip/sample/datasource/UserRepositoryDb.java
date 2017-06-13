package org.kajip.sample.datasource;

import org.kajip.sample.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("db")
public class UserRepositoryDb implements UserRepository {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Tracer tracer;

    @Autowired
    JdbcTemplate  jdbcTemplate;

    @Override
    @NewSpan("databaseAccess") // このメソッドを実行するとき、新しいSpanを開始する
    @Transactional
    public void regist() {

        // Span Tag の追加。メソッドの引数に SpanTagアノテーションを渡す方法もある
        tracer.addTag("sample-key", "sample-value");

        jdbcTemplate.query("SELECT 1", rs -> {
            logger.info("result: {}", rs.getInt(1));
        });
    }
}
