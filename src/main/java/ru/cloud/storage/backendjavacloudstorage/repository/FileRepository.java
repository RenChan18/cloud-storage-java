package ru.cloud.storage.backendjavacloudstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cloud.storage.backendjavacloudstorage.model.File;
import ru.cloud.storage.backendjavacloudstorage.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File,String> {
    Optional<File> findFileById(String id);

    @Query("SELECT f FROM File f WHERE f.directoryId LIKE ?1")
    Optional<List<File>> findAllByDirectoryIdLike(String id);


}