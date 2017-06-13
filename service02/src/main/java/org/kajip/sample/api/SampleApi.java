package org.kajip.sample.api;

import org.kajip.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleApi {

    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "/service", method = {POST})
    public void check() {
        sampleService.regist();
    }
}
