package com.errday.artillery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ParameterController {


    @RequestMapping(value = "/login-with-id-password", method = RequestMethod.POST)
    public String loginWithIdPassword(@RequestBody IdAndPassword idAndPassword) {
        log.info("{} / {}", idAndPassword.getId(), idAndPassword.getPassword());

        return "Login Success";
    }

    static class IdAndPassword {
        private String id;
        private String password;

        public String getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }
    }
}