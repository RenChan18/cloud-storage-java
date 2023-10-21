package ru.cloud.storage.backendjavacloudstorage.service;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

@Service


public class UserService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Connection connect_to_db(String db_name, String user, String password){
        Connection connect = null;
        try {
            Class.forName("ru.cloud.storage.backendjavacloudstorage.model.User");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ db_name, user, password);
            if (connect!=null){
                System.out.println("Connection established");
            }
            else {
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return connect;
    }

    public Boolean createUser(String firstname, String lastname, String email, String hashpassword){
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("firstname", firstname);
        in.addValue("lastname", lastname);
        in.addValue("email", email);
        in.addValue("hashpassword", hashpassword);
        try {
            this.namedParameterJdbcTemplate.update("insert into users (firstname, lastname, email, hashpassword)  values (:firstname, :lastname, :email, :hashpassword);", in);
            return true;
        }catch(Exception e){
            return  false;
        }
    }
}
