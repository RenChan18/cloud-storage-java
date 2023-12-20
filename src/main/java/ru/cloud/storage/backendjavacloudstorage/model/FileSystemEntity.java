package ru.cloud.storage.backendjavacloudstorage.model;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import java.util.UUID;

@Entity
@Setter
@Getter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass


@Table(name = "file_system")

public class FileSystemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "parent_id")
    private Long parentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_type", nullable = false)
    private ItemType itemType;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "icon")
    private String icon;

}

