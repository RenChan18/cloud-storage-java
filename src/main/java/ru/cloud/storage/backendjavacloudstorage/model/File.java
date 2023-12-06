package ru.cloud.storage.backendjavacloudstorage.model;


import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "files")
public class File extends StructureElement {
    @Basic
    @Column(name = "data")
    private String data;
    @Basic
    @Column(name = "uploadedDate")
    private Date uploadedDate;
    @Basic
    @Column(name = "user_id")
    private String user_id;

}
