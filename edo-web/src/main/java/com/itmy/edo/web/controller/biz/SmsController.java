package com.itmy.edo.web.controller.biz;

import com.amazonaws.services.s3.model.Bucket;
import com.itmy.edo.common.response.Result;
import com.itmy.edo.oss.core.OssTemplate;
import com.itmy.edo.sms.utils.SmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * sms
 * @date: 2023/7/18 22:47
 * @version: 1.0.0
 */
@RestController
@RequestMapping("/biz/sms")
public class SmsController {

    @Resource
    private SmsTemplate smsTemplate;

    @GetMapping("/send")
    public Result<Boolean> send(@RequestParam String mobile,@RequestParam String templateCode,@RequestParam String templateParam ){
        Boolean aBoolean = smsTemplate.sendSms(mobile, templateCode, templateParam);
        return Result.ok();
    }

}
