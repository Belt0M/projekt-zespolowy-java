package pl.Apps.dbMovieapp.Movies.Models;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rentals {
    private int id;
    private int user_id;
    private String username;
    private int movie_id;
    private String movietitle;
    private Timestamp rental_date;
    private Timestamp return_date;
    private String status;
}
