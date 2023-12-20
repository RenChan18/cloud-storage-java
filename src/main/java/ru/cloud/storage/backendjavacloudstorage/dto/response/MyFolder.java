package ru.cloud.storage.backendjavacloudstorage.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyFolder {
    private UUID id;
    private String title;
}
