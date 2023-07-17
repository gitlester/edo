package com.itmy.edo.web.controller.biz;

import com.itmy.edo.annotation.TokenBucketLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: limeng
 * @date: 2023/7/17 22:09
 * @version: 1.0.0
 */
@RestController
public class SdkController {

    //localhost:8081/query
    @GetMapping("/query")
    @TokenBucketLimiter(1)
    public String queryUser(){
        return "queryUser";
    }

}