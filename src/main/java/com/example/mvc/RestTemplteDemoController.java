package com.example.mvc;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class RestTemplteDemoController {
    @GetMapping(value = "/wise", produces = MediaType.APPLICATION_JSON_VALUE)
    public String GetWiseSaying(){
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> requestEntity = new RequestEntity<>(
                null, null, HttpMethod.GET, URI.create("http://api.kanye.rest")
        );
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class); //String.class : String으로 값을 받겠습니다
        String responseBody = response.getBody();
        return  responseBody;
    }

}
