package ru.cloud.storage.backendjavacloudstorage.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@Builder
public class StructureElementResponse implements Serializable {
    private String id;
    private String name;
    private Long size;
    private String data;
    private Date uploadedDate;
    private String user_id;
    private String directory_id;
    private Date creationDate;
    private Date editingDate;

}