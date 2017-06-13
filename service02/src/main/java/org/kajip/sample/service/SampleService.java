package org.kajip.sample.service;

import org.kajip.sample.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SampleService {

    @Autowired
    UserRepository  userRepository;

    @Async
    @Transactional
    public void regist() {
        userRepository.regist();
    }
}
