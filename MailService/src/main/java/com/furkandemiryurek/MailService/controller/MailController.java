package com.furkandemiryurek.MailService.controller;

import com.furkandemiryurek.MailService.dto.SendMailDto;
import com.furkandemiryurek.MailService.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@Slf4j
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestBody SendMailDto sendMailDto){
        return ResponseEntity.ok().body(mailService.sendEmail(sendMailDto));
    }
}
