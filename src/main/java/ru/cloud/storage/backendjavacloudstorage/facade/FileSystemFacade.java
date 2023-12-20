package ru.cloud.storage.backendjavacloudstorage.facade;

import org.springframework.stereotype.Component;
import ru.cloud.storage.backendjavacloudstorage.dto.request.FileSystemRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FileSystemResponse;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FolderAndFileResponse;
import ru.cloud.storage.backendjavacloudstorage.dto.response.MyFile;
import ru.cloud.storage.backendjavacloudstorage.dto.response.MyFolder;
import ru.cloud.storage.backendjavacloudstorage.model.FileSystemEntity;
import ru.cloud.storage.backendjavacloudstorage.model.ItemType;

import java.util.List;
import java.util.UUID;

@Component
public class FileSystemFacade {

    public FileSystemResponse toResponse(FileSystemEntity entity) {
        return new FileSystemResponse(
                entity.getId(),
                entity.getParentId(),
                entity.getItemType(),
                entity.getTitle(),
                entity.getIcon()
        );

    }

    public FolderAndFileResponse toListResponse(List<FileSystemEntity> entities){
        return new FolderAndFileResponse(entities.stream().filter(s->s.getItemType().equals(ItemType.FOLDER)).map(s->new MyFolder(s.getId(), s.getTitle())).toList(),
        entities.stream().filter(s->s.getItemType().equals(ItemType.FILE)).map(s->new MyFile(s.getId(), s.getTitle())).toList());
    }

    public FileSystemEntity toEntity(FileSystemRequest request) {
        FileSystemEntity entity = new FileSystemEntity();
        entity.setParentId(request.getParentId());
        entity.setItemType(request.getItemType());
        entity.setTitle(request.getTitle());
        entity.setIcon(request.getIcon());
        return entity;
    }

    public void updateEntityFromRequest(FileSystemEntity entity, FileSystemRequest request) {

        entity.setParentId(request.getParentId());
        entity.setItemType(request.getItemType());
        entity.setTitle(request.getTitle());
        entity.setIcon(request.getIcon());
    }

}
