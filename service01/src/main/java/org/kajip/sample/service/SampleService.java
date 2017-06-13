
package org.kajip.sample.service;

import org.kajip.sample.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SampleService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository  userRepository;

    @Async
    public void regist() {
        logger.info("start regist");
        userRepository.regist();
        logger.info("start regist");
    }
}
