package top.leemer.springbootsendmessage.common.service;

import org.springframework.stereotype.Service;
import top.leemer.springbootsendmessage.common.utils.SendMessageUtil;

/**
 * @author LEEMER
 * Create Date: 2019-09-29
 */
@Service
public class SendMessageService {

    /**
     * 生成随机数
     * @param num 位数
     * @return
     */
    public static String createRandomNum(int num){
        String randomNumStr = "";
        for(int i = 0; i < num;i ++){
            int randomNum = (int)(Math.random() * 10);
            randomNumStr += randomNum;
        }
        return randomNumStr;
    }

    /**
     * 发送短信 - 中国网建 SMS短信
     */
    public void sendMessage(){
        long timeout = 5;
        String code = createRandomNum(6);
        String sendPhoneNum = "136*******";
        Integer resultCode = SendMessageUtil.send("leemer-msg","d41d8********",sendPhoneNum,"尊敬的用户，您好，您的验证码为："+code+"，请于"+timeout+"分钟内正确输入，如非本人操作，请忽略此短信。");
        if (resultCode>0){
            //手机验证码发送成功，业务处理
        }

        System.out.println(SendMessageUtil.getMessage(resultCode));
        if (resultCode > 0){
            System.out.println("已发送至："+sendPhoneNum+"，验证码："+ code);
        }
    }

}
