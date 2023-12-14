package ru.cloud.storage.backendjavacloudstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cloud.storage.backendjavacloudstorage.model.File;
import ru.cloud.storage.backendjavacloudstorage.model.Folder;

import java.util.List;
import java.util.Optional;
@Repository

public interface DirectoryRepository  extends JpaRepository<Folder,String> {
        Optional<Folder> findDirectoryById(String id);

        @Query("SELECT d FROM Folder d WHERE d.directoryId LIKE ?1")
        Optional<List<Folder>> findAllByDirectoryIdLike(String id);




    }
}
