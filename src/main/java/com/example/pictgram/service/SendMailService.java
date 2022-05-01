package com.example.pictgram.service;

import java.nio.charset.StandardCharsets;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(Context context) {

        javaMailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
                helper.setFrom("[Gmail の E メールアドレス]");
                helper.setTo("[Gmail の E メールアドレス]");
                helper.setSubject("タイトル");
                helper.setText("本文");
            }
        });

    }

}