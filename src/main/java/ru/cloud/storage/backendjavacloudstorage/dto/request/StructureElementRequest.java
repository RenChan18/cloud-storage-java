package ru.cloud.storage.backendjavacloudstorage.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StructureElementRequest {

    private String name;
    private Long size;
    private String data;
    private Date uploadedDate;
    private String user_id;
    private String directory_id;
    private Date creationDate;
    private Date editingDate;
}
