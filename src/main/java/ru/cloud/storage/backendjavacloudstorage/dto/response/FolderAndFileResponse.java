package ru.cloud.storage.backendjavacloudstorage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FolderAndFileResponse {
    private List<MyFolder> folders;
    private List<MyFile> files;
}
