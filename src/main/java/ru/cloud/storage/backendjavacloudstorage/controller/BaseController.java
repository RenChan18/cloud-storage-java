package ru.cloud.storage.backendjavacloudstorage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cloud.storage.backendjavacloudstorage.service.BaseService;
import ru.cloud.storage.backendjavacloudstorage.util.ResponseError;

import java.time.LocalDateTime;

public abstract class BaseController<T extends BaseService<Q, A>, Q, A>{

    private final T service;

    public BaseController(T service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<A> getReferenceById(@PathVariable("id") String id) {
        A response = service.getReferenceById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<A> create(@RequestBody Q request) {
        A response = service.create(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<A> update(@RequestBody Q request) {
        A response = service.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        Boolean response = service.delete(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ResponseError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
