package ru.cloud.storage.backendjavacloudstorage.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cloud.storage.backendjavacloudstorage.model.User;
import ru.cloud.storage.backendjavacloudstorage.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
   private final UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;

   }

   @GetMapping("/hello_world")
   public ResponseEntity<String> helloWorld()   {return new ResponseEntity<>("Hello, World", HttpStatus.OK); }

   @PostMapping("/createUser")
   public ResponseEntity<String> createUser(@RequestParam("firstname") String firstname,
                                          @RequestParam("lastname") String lastname,
                                          @RequestParam("email") String email,
                                          @RequestParam("hashpassword") String hashpassword,
                                          HttpServletRequest httpServletRequest) throws Exception {
         Boolean response = userService.createUser(firstname, lastname, email, hashpassword);
         return new ResponseEntity<>("create user "+email, HttpStatus.OK);
         //.ok(response);
   }
}
/*
@PostMapping(path = "user", params={"userName"})
public ResponseEntity<String> saveUser(@RequestParam("userName") String userName) {
}*/

