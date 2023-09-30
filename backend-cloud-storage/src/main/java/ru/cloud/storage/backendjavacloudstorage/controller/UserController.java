package ru.cloud.storage.backendjavacloudstorage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

   @GetMapping("/hello_world")
   public ResponseEntity<String> test()
   {
      return new ResponseEntity<>("Hello, World", HttpStatus.OK);
   }

   @GetMapping("/hello_world2")
   public ResponseEntity<String> test2()
   {
      return new ResponseEntity<>("Hello, World!!", HttpStatus.OK);
   }
}