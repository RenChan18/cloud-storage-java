package ru.cloud.storage.backendjavacloudstorage.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.cloud.storage.backendjavacloudstorage.dto.request.StructureElementRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.StructureElementResponse;
import ru.cloud.storage.backendjavacloudstorage.model.File;
import ru.cloud.storage.backendjavacloudstorage.model.Folder;
import ru.cloud.storage.backendjavacloudstorage.model.StructureElement;
import ru.cloud.storage.backendjavacloudstorage.service.StructureElementService;

@Component
@RequiredArgsConstructor
public class StructureElementFacade {

    public StructureElementResponse toResponse(StructureElement structureElement) {
        return StructureElementResponse.builder()
                .id(structureElement.getId())
                .name(structureElement.getName())
                .size(structureElement.getSize())
                .build();
    }


    @Autowired
    private StructureElementService structureElementService;

    public String getStructureElementById(String id) {
        StructureElement structureElement = structureElementService.getStructureElementById(id);
        if (structureElement != null) {
            return "StructureElement found";
        } else {
            return "StructureElement not found";
        }
    }

    public String createStructureElement(StructureElementRequest request) {
        StructureElement structureElement = convertRequestToStructureElement(request);
        structureElementService.createStructureElement(structureElement);
        return "StructureElement created successfully";
    }

    public String updateStructureElement(String id, StructureElementRequest request) {
        StructureElement structureElement = convertRequestToStructureElement(request);
        boolean updated = structureElementService.updateStructureElement(id, structureElement);
        if (updated) {
            return "StructureElement updated successfully";
        } else {
            return "StructureElement not found";
        }
    }

    public String deleteStructureElement(String id) {
        boolean deleted = structureElementService.deleteStructureElement(id);
        if (deleted) {
            return "StructureElement deleted successfully";
        } else {
            return "StructureElement not found";
        }
    }

    private StructureElement convertRequestToStructureElement(StructureElementRequest request) {
        StructureElement structureElement = new StructureElement();
        structureElement.setName(request.getName());
        structureElement.setSize(request.getSize());
        structureElement.setData(request.getData());
        structureElement.setUploadedDate(request.getUploadedDate());
        structureElement.setUser_id(request.getUser_id());
        structureElement.setDirectory_id(request.getDirectory_id());
        structureElement.setCreationDate(request.getCreationDate());
        structureElement.setEditingDate(request.getEditingDate());
        return structureElement;
    }



}
