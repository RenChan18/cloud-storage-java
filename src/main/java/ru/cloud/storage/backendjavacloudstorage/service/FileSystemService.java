package ru.cloud.storage.backendjavacloudstorage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.cloud.storage.backendjavacloudstorage.dto.request.FileSystemRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FileSystemResponse;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FolderAndFileResponse;
import ru.cloud.storage.backendjavacloudstorage.facade.FileSystemFacade;
import ru.cloud.storage.backendjavacloudstorage.model.FileSystemEntity;
import ru.cloud.storage.backendjavacloudstorage.repository.FileSystemRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class FileSystemService {

    private final FileSystemFacade fileSystemFacade;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final FileSystemRepository fileSystemRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public FileSystemResponse getItemById(Long id) {
        return fileSystemRepository.findById(id)
                .map(fileSystemFacade::toResponse)
                .orElse(null);
    }
    public FolderAndFileResponse getItems() {
        List<FileSystemEntity> entities = fileSystemRepository.findAll();
        return fileSystemFacade.toListResponse(entities);
    }

    public FolderAndFileResponse createItem(FileSystemRequest request) {
        try {
            //FileSystemEntity newEntity = fileSystemFacade.toEntity(request);
           // FileSystemEntity savedEntity = fileSystemRepository.save(newEntity);
            List<FileSystemEntity> allEntities = fileSystemRepository.findAll();
            return fileSystemFacade.toListResponse(allEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public boolean updateItem(UUID id, FileSystemRequest request) {
        try {
            FileSystemEntity entity = fileSystemRepository.findById(id);
            fileSystemFacade.updateEntityFromRequest(entity, request);
            fileSystemRepository.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void deleteItem(UUID id) {
        fileSystemRepository.deleteById(id);
    }

    public List<FileSystemResponse> getAllItems() {
        List<FileSystemEntity> entities = fileSystemRepository.findAll();
        return entities.stream()
                .map(fileSystemFacade::toResponse)
                .collect(Collectors.toList());
    }
}
