package ru.cloud.storage.backendjavacloudstorage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cloud.storage.backendjavacloudstorage.model.ItemType;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileSystemResponse {
    private UUID id;
    private Long parentId;
    private ItemType itemType;
    private String title;
    private String icon;
}
