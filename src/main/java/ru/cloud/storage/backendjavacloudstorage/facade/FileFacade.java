package ru.cloud.storage.backendjavacloudstorage.facade;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.cloud.storage.backendjavacloudstorage.dto.response.FileResponse;
import ru.cloud.storage.backendjavacloudstorage.model.File;

@Component
@RequiredArgsConstructor
public class FileFacade {
    public FileResponse toResponse(File file){
        return FileResponse.builder()
                .id(file.getId())
                .name(file.getName())
                .size(file.getSize())

    }
}
