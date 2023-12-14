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
@Table(name = "directories")

public class Folder extends StructureElement {

}
