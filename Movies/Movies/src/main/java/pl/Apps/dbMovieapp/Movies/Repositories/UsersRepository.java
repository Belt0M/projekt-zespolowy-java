package pl.Apps.dbMovieapp.Movies.Repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import pl.Apps.dbMovieapp.Movies.Models.Users;

import java.util.List;

@Repository
public class UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Users> getAllUsers() {
        return jdbcTemplate.query("SELECT * from USERS", BeanPropertyRowMapper.newInstance(Users.class));
    }

    public Users getUser(int id){
        return jdbcTemplate.queryForObject("SELECT id, username, email, first_name, last_name FROM USERS WHERE id=?",
                BeanPropertyRowMapper.newInstance(Users.class), id);
    }

    public int addUser(List<Users> user){
        user.forEach(users -> jdbcTemplate.update("INSERT INTO USERS (username, email, first_name, last_name) VALUES (?,?,?,?)",
                users.getUsername(), users.getEmail(), users.getFirst_name(), users.getLast_name()
        ));
        return 1;
    }

    public Users updateUser(int id, Users user){
        jdbcTemplate.update("UPDATE USERS SET username=?, email=?, first_name=?, last_name=? WHERE id=?",
                user.getUsername(), user.getEmail(), user.getFirst_name(), user.getLast_name(), id);
        return getUser(id);
    }

    public int deleteUser(int id){
        return jdbcTemplate.update("DELETE FROM USERS WHERE id=?", id);
    }

}
