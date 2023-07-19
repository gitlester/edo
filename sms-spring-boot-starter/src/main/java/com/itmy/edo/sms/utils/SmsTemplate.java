package com.itmy.edo.sms.utils;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.itmy.edo.sms.core.SmsProperties;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @date: 2023/7/19 22:01
 * @version: 1.0.0
 */
public class SmsTemplate {
    @Resource
    private Client client;
    @Resource
    private SmsProperties smsProperties;
    /**
     * 发送短信
     * @param mobile 手机号，多个手机号之间使用逗号隔开，手机号个数不要超过1000
     * @param templateCode 模板code 决定短信内容
     * @param templateParam 模板参数 短信内容中动态变量占位  注意：该字符串为JSON格式
     * @return boolean   返回true:发送短信超过    返回false：发送短信失败
     */
    public Boolean sendSms(String mobile, String templateCode, String templateParam) {
        //ctrl + alt +t ---》选择 try catch
        try {


            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(mobile)
                    .setSignName(smsProperties.getSignName())
                    .setTemplateCode(templateCode)
                    .setTemplateParam(templateParam);
            SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
            String code = sendSmsResponse.getBody().getCode();
            if ("OK".equals(code)) {


                return true;
            }
        } catch (Exception e) {


            e.printStackTrace();
            return false;
        }
        return false;
    }
}
