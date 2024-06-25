package pl.Apps.dbMovieapp.Movies.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.Apps.dbMovieapp.Movies.Models.Rentals;

import java.util.List;

@Repository
public class RentalsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rentals> getAllRentals() {
        return jdbcTemplate.query("SELECT r.id, u.username as username, m.title as movietitle, r.rental_date, r.return_date, r.status FROM USERS u join RENTALS r on u.id=r.user_id join MOVIES m on m.id=r.movie_id",
                BeanPropertyRowMapper.newInstance(Rentals.class));
    }

    public Rentals getRental(int id){
        return jdbcTemplate.queryForObject("SELECT r.id, u.username as username, m.title as movietitle, r.rental_date, r.return_date, r.status FROM USERS u join RENTALS r on u.id=r.user_id join MOVIES m on m.id=r.movie_id WHERE r.id=?",
                BeanPropertyRowMapper.newInstance(Rentals.class), id);
    }

    public int addRental(List<Rentals> rental){
        rental.forEach(rentals -> jdbcTemplate.update("INSERT INTO RENTALS (user_id, movie_id, rental_date, return_date, status) VALUES (?,?,?,?,?)",
                rentals.getUser_id(), rentals.getMovie_id(), rentals.getRental_date(), rentals.getReturn_date(), rentals.getStatus()
        ));
        return 1;
    }

    public Rentals updateRental(int id, Rentals rental){
        jdbcTemplate.update("UPDATE RENTALS SET user_id=?, movie_id=?, rental_date=?, return_date=?, status=? WHERE id=?",
                rental.getUser_id(), rental.getMovie_id(), rental.getRental_date(), rental.getReturn_date(), rental.getStatus(), rental.getId());
        return getRental(id);
    }

    public int deleteRental(int id){
        return jdbcTemplate.update("DELETE FROM RENTALS WHERE id=?", id);
    }
}
