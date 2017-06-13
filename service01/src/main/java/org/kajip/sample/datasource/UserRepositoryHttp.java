package org.kajip.sample.datasource;

import org.kajip.sample.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("http")
public class UserRepositoryHttp implements UserRepository {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void regist() {
        String url = "http://localhost:8082/service";

        ResponseEntity<String> result =
                restTemplate.postForEntity(url, "", String.class);

        logger.info("{}", result);
    }
}
