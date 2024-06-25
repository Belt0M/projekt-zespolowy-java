package pl.Apps.dbMovieapp.Movies.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private int id;
    private String username;
    private String email;
    private String first_name;
    private String last_name;
}
