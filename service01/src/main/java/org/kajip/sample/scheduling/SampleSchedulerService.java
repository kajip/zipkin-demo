package org.kajip.sample.scheduling;

import org.kajip.sample.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * タイマー起動するコンポーネント
 */
@Component
public class SampleSchedulerService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SampleService sampleService;

    @Scheduled(fixedRate=30000L)
    public void sample() {
        logger.info("wake up");
        sampleService.regist();
    }
}
