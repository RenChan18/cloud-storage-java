package ru.cloud.storage.backendjavacloudstorage.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cloud.storage.backendjavacloudstorage.dto.request.FileRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FileResponse;
import ru.cloud.storage.backendjavacloudstorage.model.StructureElement;
import ru.cloud.storage.backendjavacloudstorage.service.FileService;
/*
@Component
@RequiredArgsConstructor
public class StructureElementFacade {

    public FileResponse toResponse(StructureElement structureElement) {
        return FileResponse.builder()
                .id(structureElement.getId())
                .name(structureElement.getName())
                .size(structureElement.getSize())
                .data(structureElement.getData())
                .build();
    }


    @Autowired
    private FileService fileService;

    public String getStructureElementById(String id) {
        StructureElement structureElement = fileService.getStructureElementById(id);
        if (structureElement != null) {
            return "StructureElement found";
        } else {
            return "StructureElement not found";
        }
    }

    public String createStructureElement(FileRequest request) {
        StructureElement structureElement = convertRequestToStructureElement(request);
        fileService.createStructureElement(structureElement);
        return "StructureElement created successfully";
    }

    public String updateStructureElement(String id, FileRequest request) {
        StructureElement structureElement = convertRequestToStructureElement(request);
        boolean updated = fileService.updateStructureElement(id, structureElement);
        if (updated) {
            return "StructureElement updated successfully";
        } else {
            return "StructureElement not found";
        }
    }

    public String deleteStructureElement(String id) {
        boolean deleted = fileService.deleteStructureElement(id);
        if (deleted) {
            return "StructureElement deleted successfully";
        } else {
            return "StructureElement not found";
        }
    }

    private StructureElement convertRequestToStructureElement(FileRequest request) {
        StructureElement structureElement = new StructureElement();
        structureElement.setName(request.getName());
        structureElement.setSize(request.getSize());
        structureElement.setData(request.getData());
        structureElement.setUploadedDate(request.getUploadedDate());
        structureElement.setUserId(request.getUser_id());
        structureElement.setDirectoryId(request.getDirectory_id());
        structureElement.setCreationDate(request.getCreationDate());
        structureElement.setEditingDate(request.getEditingDate());
        return structureElement;
    }



}
*/