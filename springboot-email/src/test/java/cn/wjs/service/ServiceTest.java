package cn.wjs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private MailService mailService;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 发送简单纯文本邮件
     */
    @Test
    public void sendSimpleMail() {
        mailService.sendAttachmentMail("jinsen.wu@hitgoo.net", "发送邮件测试", "大家好，这是我用springboot进行发送邮件测试", "/Users/wujinsen/Pictures/7975421-f5c844f67e601df3.png");
    }

}
