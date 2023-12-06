package ru.cloud.storage.backendjavacloudstorage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Setter
@Getter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass



public class StructureElement {

    @Id
    @Basic
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "size")
    private Long size;

}
