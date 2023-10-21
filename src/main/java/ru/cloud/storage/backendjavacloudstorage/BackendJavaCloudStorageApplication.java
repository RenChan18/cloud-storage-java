package ru.cloud.storage.backendjavacloudstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.cloud.storage.backendjavacloudstorage.model.User;

@SpringBootApplication
public class BackendJavaCloudStorageApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendJavaCloudStorageApplication.class, args);

		//add psql/jdbc
/*
		User db = new User();
		db.connect_to_db("firstdb", "renata", "easypass");*/
	}

}
