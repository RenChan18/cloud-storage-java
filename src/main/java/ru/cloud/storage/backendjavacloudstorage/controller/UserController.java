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

   @PostMapping("/create_user")
   public ResponseEntity<Boolean> createUser(@RequestBody User user) throws Exception {
      return new ResponseEntity<>(
              userService.createUser(user.getFirstname(),
                      user.getLastname(),
                      user.getEmail(),
                      user.getHashpassword()),
              HttpStatus.OK);
   }

   @PutMapping("/update_user")
   public ResponseEntity<Boolean> updateUser(@PathVariable Long userId, @RequestBody User user) throws Exception {
      return new ResponseEntity<>(
              userService.updateUser(userId,
                      user.getFirstname(),
                      user.getLastname(),
                      user.getEmail(),
                      user.getHashpassword()),
              HttpStatus.OK);
   }
}
