package com.example.demo8;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Testcontroller {
  @GetMapping("/")
  public String getHello() {
    return "hello world";
  }

}
