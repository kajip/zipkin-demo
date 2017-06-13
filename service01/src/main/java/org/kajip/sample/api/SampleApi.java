package org.kajip.sample.api;

import org.kajip.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SampleApi {

    @Autowired
    SampleService sample1Service;

    @RequestMapping("/service")
    @ResponseBody
    public void invoke() {
        sample1Service.regist();
    }
}
