package ru.cloud.storage.backendjavacloudstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cloud.storage.backendjavacloudstorage.model.FileSystemEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository

public interface FileSystemRepository extends JpaRepository<FileSystemEntity,Long> {
    FileSystemEntity findById(UUID id);
    Optional<FileSystemEntity> deleteById(UUID id);
    List<FileSystemEntity> findAllByIdIn(Collection<UUID> ids);
    List<FileSystemEntity> findAllByTitleLike(String title);
}


