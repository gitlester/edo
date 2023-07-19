package com.itmy.edo.sms.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: limeng
 * @date: 2023/7/19 21:57
 * @version: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "aliyun.sms")// 绑定配置文件中该前绰的配置
public class SmsProperties {


    /**
     * 访问阿里云服务访问ID
     */
    private String accessId;
    /**
     * 访问阿里云服务访问秘钥
     */
    private String accessKeySecret;

    /**
     * 访问阿里云短信服务接口地址
     */
    private String endpoint;

    /**
     * 阿里云短信签名-名称
     */
    private String signName;
}
