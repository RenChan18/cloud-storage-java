package ru.cloud.storage.backendjavacloudstorage.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cloud.storage.backendjavacloudstorage.dto.request.UserRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.UserResponse;
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

   @PostMapping("/create")
   public ResponseEntity<String> createUser(
           @RequestBody UserRequest userRequest) {
      return new ResponseEntity<>("Add record: " + userService.createUser(userRequest), HttpStatus.OK);
   }

@PostMapping("/update/{userId}")
   public ResponseEntity<String> updateUser( @RequestBody UserRequest userRequest) {
      return new ResponseEntity<>("Update record: " + userService.updateUser(userRequest), HttpStatus.OK);
   }

   @PostMapping("/delete/{userId}")
   public ResponseEntity<String> deleteUser(@RequestBody UserRequest userRequest) throws Exception {
      return new ResponseEntity<>("Delete record: " + userService.deleteUser(userRequest), HttpStatus.OK);
   }


  @GetMapping("/{firstName}")
  public ResponseEntity<UserResponse> findUserByFirstName(@PathVariable String firstName) {
     return new ResponseEntity<>(userService.findUserByFirstName(firstName), HttpStatus.OK);
  }
}

