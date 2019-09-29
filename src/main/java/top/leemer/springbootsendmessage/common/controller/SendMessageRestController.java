package top.leemer.springbootsendmessage.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leemer.springbootsendmessage.common.service.SendMessageService;

/**
 * @author LEEMER
 * Create Date: 2019-09-29
 */
@RestController
@RequestMapping("/message")
public class SendMessageRestController {

    private SendMessageService sendMessageService;

    @Autowired
    public SendMessageRestController(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    //发送短信
    @GetMapping("/send")
    public void sendMessage(){
        sendMessageService.sendMessage();
    }

}
