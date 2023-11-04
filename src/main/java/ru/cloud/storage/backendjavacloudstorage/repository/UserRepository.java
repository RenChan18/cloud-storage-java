package ru.cloud.storage.backendjavacloudstorage.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cloud.storage.backendjavacloudstorage.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByFirstName(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserById(Long id);
    List<User> findAllByIdIn(Collection<Long> id);
    @Query("SELECT u FROM User u WHERE u.firstName LIKE ?1")
    List<User> findAllByFirstNameLike(String firstName);
}