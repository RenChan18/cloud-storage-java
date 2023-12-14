package ru.cloud.storage.backendjavacloudstorage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.cloud.storage.backendjavacloudstorage.dto.request.FileRequest;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FileResponse;

import ru.cloud.storage.backendjavacloudstorage.repository.FileRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileService implements BaseService<FileRequest, FileResponse> {
    private final FileFacade fileFacade;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final FileRepository fileRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public FileResponse getReferenceById(String id) {
        return fileFacade.toResponse(fileRepository.findFileById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id " + id)));
    }

    @Override
    public FileResponse create(FileRequest fileRequest) { //createFile, createDirectories
        try {
            if(0 != this.namedParameterJdbcTemplate.update("insert into files (id, name, user_id, directory_id, size, upload_at)  values (:id, :name, :userId, :directoryId, :size, :editingDate);"
                    , fileFacade.toCreateFile(fileRequest)))
                return fileFacade.toResponse(fileFacade.toFile(fileRequest));
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public FileResponse update(FileRequest fileRequest) {
        try {
            if(0 != this.namedParameterJdbcTemplate.update("UPDATE files SET name = :name, directory_id = :directoryId, size = :size, upload_at = :editingDate WHERE id = :id"
                    , fileFacade.toUpdateFile(fileRequest)))
                return fileFacade.toResponse(fileFacade.toFile(fileRequest));
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean delete(FileRequest fileRequest) {
        try {
            if (0 != this.namedParameterJdbcTemplate.update("DELETE FROM files WHERE id = :id"
                    , fileFacade.toDeleteFile(fileRequest)))
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
