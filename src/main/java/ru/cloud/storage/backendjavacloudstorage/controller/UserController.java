package ru.cloud.storage.backendjavacloudstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cloud.storage.backendjavacloudstorage.dto.request.UserRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.UserResponse;
import ru.cloud.storage.backendjavacloudstorage.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController extends BaseController<UserService, UserRequest, UserResponse>{
    @Autowired
    private UserService userService;

    public UserController(UserService service) {
        super(service);
    }


    @GetMapping("/hello_world")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello, World", HttpStatus.OK);
    }

    @PostMapping("/createUserWithJDBC")
    public ResponseEntity<String> createUserWithJDBC(
            @RequestParam("user") UserRequest userRequest) {
        return new ResponseEntity<>("Добавленно записей: " + userService.createUserWithJDBC(userRequest), HttpStatus.OK);
    }

    @PostMapping("/createUserWithJPA")
    public ResponseEntity<String> createUserWithJPA(
            @RequestParam("user") UserRequest userRequest) {
        return new ResponseEntity<>("Добавленна запись: " + userService.createUserWithJPA(userRequest).toString(), HttpStatus.OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<UserResponse> findUserByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(userService.findUserByFirstName(firstName), HttpStatus.OK);
    }
}

