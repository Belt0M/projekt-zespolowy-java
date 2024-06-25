package pl.Apps.dbMovieapp.Movies.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies {

    private int id;
    private String title;
    private LocalDate release_year;
    private String director;
    private float rating;
    private String description;
    private int category_id;
    private String category_name;

}
