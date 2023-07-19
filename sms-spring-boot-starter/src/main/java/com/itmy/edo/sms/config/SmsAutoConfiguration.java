package com.itmy.edo.sms.config;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.itmy.edo.sms.utils.SmsTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @description: TODO
 * @date: 2023/7/19 22:36
 * @version: 1.0.0
 */
@Configuration
@ConditionalOnClass(SendSmsRequest.class)
@Import(SmsConfig.class)
public class SmsAutoConfiguration {
    // 将工具类导入IOC容器
    @Bean
    @ConditionalOnMissingBean(name = "smsTemplate")
    public SmsTemplate smsTemplate(){


        return new SmsTemplate();
    }

}
