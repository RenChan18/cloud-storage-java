package ru.cloud.storage.backendjavacloudstorage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cloud.storage.backendjavacloudstorage.model.ItemType;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileSystemRequest {
    private UUID id;
    private Long parentId;
    private ItemType itemType;
    private String title;
    private String icon;

}