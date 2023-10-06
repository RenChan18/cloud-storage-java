package ru.cloud.storage.backendjavacloudstorage.model;

import java.time.LocalDateTime;
import java.util.Date;

public class File extends StructureElement {
    private Date uploadedDate;


    public File(String nameOfElement, Long sizeOfElement, Date uploadedDate) {
        super(nameOfElement, sizeOfElement);
        this.uploadedDate = uploadedDate;
    }
}
