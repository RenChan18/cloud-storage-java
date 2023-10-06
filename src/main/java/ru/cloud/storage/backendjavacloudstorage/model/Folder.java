package ru.cloud.storage.backendjavacloudstorage.model;


import java.util.Date;

public class Folder extends StructureElement {
    private Date creationDate;
    private Date editingDate;


    public Folder(String nameOfElement, Long sizeOfElement, Date creationDate, Date editingDate) {
        super(nameOfElement, sizeOfElement);
        this.creationDate = creationDate;
        this.editingDate = editingDate;
    }
}
