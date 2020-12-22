package com.webspoons.snippet_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SnippetTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnippetTestApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        return  new BCryptPasswordEncoder();
    }

}
