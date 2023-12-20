package ru.cloud.storage.backendjavacloudstorage.controller;// FileSystemController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cloud.storage.backendjavacloudstorage.dto.request.FileSystemRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FileSystemResponse;
import ru.cloud.storage.backendjavacloudstorage.model.FileSystemEntity;
import ru.cloud.storage.backendjavacloudstorage.service.FileSystemService;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FolderAndFileResponse;
import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/api/filesystem")
public class FileSystemController {
    private final FileSystemService fileSystemService;
    @Autowired
    public FileSystemController(FileSystemService fileSystemService) {

        this.fileSystemService = fileSystemService;
    }
    @GetMapping("/items/{id}")
    public Object getItemById(@PathVariable Long id) {
        FileSystemResponse fileSystemEntity = fileSystemService.getItemById(id);
        return fileSystemEntity != null ?
                ResponseEntity.ok() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/items")
    public ResponseEntity<FolderAndFileResponse> getItems() {
        FolderAndFileResponse response = fileSystemService.getItems();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/items")
    public ResponseEntity<String> createItem(
            @RequestBody FileSystemRequest request) {
        fileSystemService.createItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item created successfully");
    }

    @PostMapping("/items/{id}")
    public ResponseEntity<String> updateItem(@PathVariable UUID id, @RequestBody FileSystemRequest fileRequest) {
        boolean updated = fileSystemService.updateItem(id, fileRequest);
        return updated
                ? new ResponseEntity<>("Item updated successfully", HttpStatus.OK)
                : new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
    }


    @PostMapping("/items/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable UUID id) {
        fileSystemService.deleteItem(id);
        return new ResponseEntity<>("Item deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<FileSystemResponse>> getAllItems() {
        List<FileSystemResponse> items = fileSystemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}