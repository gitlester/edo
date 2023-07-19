package com.itmy.edo.sms.config;


import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import com.itmy.edo.sms.core.SmsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @description: sms配置类
 * @date: 2023/7/19 22:29
 * @version: 1.0.0
 */
@Configuration
@EnableConfigurationProperties(SmsProperties.class)
public class SmsConfig {


    @Resource
    private SmsProperties smsProperties;

    @Bean
    public Client client() {


        try {


            Config config = new Config()
                    // 您的AccessKey ID
                    .setAccessKeyId(smsProperties.getAccessId())
                    // 您的AccessKey Secret
                    .setAccessKeySecret(smsProperties.getAccessKeySecret());
            // 访问的域名
            config.endpoint = smsProperties.getEndpoint();
            return new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
