package ru.cloud.storage.backendjavacloudstorage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cloud.storage.backendjavacloudstorage.model.File;
import ru.cloud.storage.backendjavacloudstorage.model.Folder;
import ru.cloud.storage.backendjavacloudstorage.model.StructureElement;
import ru.cloud.storage.backendjavacloudstorage.service.FileService;


@RestController
@RequestMapping("/api/structure-elements")
public class StructureElementController {

        @Autowired
        private FileService fileService;

        @GetMapping("/{id}")
        public ResponseEntity<StructureElement> getStructureElementById(@PathVariable String id) {
            StructureElement structureElement = fileService.getStructureElementById(id);
            if (structureElement != null) {
                return new ResponseEntity<>(structureElement, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("/file")
        public ResponseEntity<String> createFile(@RequestBody File file) {
            fileService.save(file); // общий метод create
            return new ResponseEntity<>("File created successfully", HttpStatus.CREATED);
        }

        @PostMapping("/folder")
        public ResponseEntity<String> createFolder(@RequestBody Folder folder) {
            fileService.save(folder);
            return new ResponseEntity<>("Folder created successfully", HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<String> updateStructureElement(@PathVariable String id, @RequestBody StructureElement structureElement) {
            boolean updated = fileService.updateStructureElement(id, structureElement);
            if (updated) {
                return new ResponseEntity<>("StructureElement updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("StructureElement not found", HttpStatus.NOT_FOUND);
            }
        }




        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteStructureElement(@PathVariable String id) {
            boolean deleted = fileService.deleteStructureElement(id);
            if (deleted) {
                return new ResponseEntity<>("StructureElement deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("StructureElement not found", HttpStatus.NOT_FOUND);
            }
        }
}


