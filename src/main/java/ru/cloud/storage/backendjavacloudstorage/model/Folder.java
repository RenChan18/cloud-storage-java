package ru.cloud.storage.backendjavacloudstorage.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "folder")

public class Folder extends StructureElement {
    @Id
    @Basic
    @Column(name = "directory_id")
    private String directory_id;
    @Basic
    @Column(name = "creation_date")
    private Date creationDate;
    @Basic
    @Column(name = "editing_date")
    private Date editingDate;

}
