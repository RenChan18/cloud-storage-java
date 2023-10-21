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
    private String name;
    private Long size;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private Long id;


}
