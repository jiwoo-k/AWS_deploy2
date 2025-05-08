package com.lec.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //설정에 있는 포트가 아닌 랜덤 포트를 사용
class HomeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate; //Test에서 쓰는 Bean. Spring Container 에 있으니 주입받자

    @Test
    void hello(){
        ResponseEntity<String> response = restTemplate.getForEntity("/aws/v2", String.class);

        assertEquals("<h1>AWS 배포 v2</h1>", response.getBody());
    }
}