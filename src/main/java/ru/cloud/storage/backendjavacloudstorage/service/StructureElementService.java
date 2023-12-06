package ru.cloud.storage.backendjavacloudstorage.service;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
import ru.cloud.storage.backendjavacloudstorage.model.File;
import ru.cloud.storage.backendjavacloudstorage.model.Folder;
import ru.cloud.storage.backendjavacloudstorage.model.StructureElement;

import java.util.Optional;

@Service
public class StructureElementService {

    @Autowired
    private File fileRepository;

    @Autowired
    private Folder folderRepository;

    public StructureElement getStructureElementById(String id) {
        Optional<File> file = fileRepository.findById(id);
        if (file.isPresent()) {
            return file.get();
        } else {
            Optional<Folder> folder = folderRepository.findById(id);
            return folder.orElse(null);
        }
    }

    public void createFile(File file) {
        fileRepository.save(file);
    }

    public void createFolder(Folder folder) {
        folderRepository.save(folder);
    }

    public boolean updateStructureElement(String id, StructureElement structureElement) {
        Optional<File> file = fileRepository.findById(id);
        if (file.isPresent()) {
            structureElement.setId(id);
            fileRepository.save((File) structureElement);
            return true;
        } else {
            Optional<Folder> folder = folderRepository.findById(id);
            if (folder.isPresent()) {
                structureElement.setId(id);
                folderRepository.save((Folder) structureElement);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean deleteStructureElement(String id) {
        Optional<File> file = fileRepository.findById(id);
        if (file.isPresent()) {
            fileRepository.delete(file.get());
            return true;
        } else {
            Optional<Folder> folder = folderRepository.findById(id);
            if (folder.isPresent()) {
                folderRepository.delete(folder.get());
                return true;
            } else {
                return false;
            }
        }
    }
}
