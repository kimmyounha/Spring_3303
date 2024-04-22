package com.example.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/MvcTest")
public class ProblemSolveController {
    @GetMapping(value = "/get_test")
    public String gettest(){
        return "get";
    }

    @PostMapping(value = "/post_test")
    public String posttest(){
        return "post";
    }

    @PutMapping(value = "/put_test")
    public String puttest(){
        return "put";
    }

}
