package com.furkandemiryurek.MailService.service;

import com.furkandemiryurek.MailService.dto.SendMailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(SendMailDto dto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(dto.getFrom());
            message.setTo(dto.getTo());
            message.setSubject(dto.getSubject());
            message.setText(dto.getText());
            mailSender.send(message);
        }catch (Exception e){
            return e.getMessage();
        }

        return "Mail has been sent successfully to : " + dto.getTo();
    }

    @KafkaListener(topics = "furkan")
    public void consume(ConsumerRecord<String,String> payload){
        String to = payload.value();
        SendMailDto mailDto = new SendMailDto();
        mailDto.setTo(to);
        mailDto.setText("Order has been placed successfully.");
        mailDto.setSubject("Order Confirmation");
        sendEmail(mailDto);
    }


}
