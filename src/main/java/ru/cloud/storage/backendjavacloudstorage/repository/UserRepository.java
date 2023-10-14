package ru.cloud.storage.backendjavacloudstorage.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //@Query("select * from users where email like concat('%',:email)")
    //User userByEmail(@Param("email") String email);
}
