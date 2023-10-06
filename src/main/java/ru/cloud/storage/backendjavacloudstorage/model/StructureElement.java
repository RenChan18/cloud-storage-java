package ru.cloud.storage.backendjavacloudstorage.model;

public class StructureElement {
    private String nameOfElement;
    private Long sizeOfElement;

    public StructureElement(String nameOfElement, Long sizeOfElement){
        this.nameOfElement = nameOfElement;
        this.sizeOfElement = sizeOfElement;
    }

    public void setName(String newName){}

    public void copyElement(){}

    public void MoveElement(){}

    public void removeElement(){}
}
