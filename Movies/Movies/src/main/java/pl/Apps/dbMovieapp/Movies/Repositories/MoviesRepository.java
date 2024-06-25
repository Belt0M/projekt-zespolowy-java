package pl.Apps.dbMovieapp.Movies.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import pl.Apps.dbMovieapp.Movies.Models.Movies;

import java.util.List;

@Repository
public class MoviesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Movies> getAllMovies() {
        String sql = "SELECT m.id AS id, m.title AS title, m.release_year AS release_year, m.director AS director, " +
                "m.rating AS rating, m.description AS description, m.category_id AS category_id, c.name AS category_name " +
                "FROM CATEGORIES c JOIN MOVIES m ON c.id = m.category_id";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movies.class));
    }

    public Movies getMovie(int id){
        String sql = "SELECT m.id AS id, m.title AS title, m.release_year AS release_year, m.director AS director, " +
                "m.rating AS rating, m.description AS description, m.category_id AS category_id, c.name AS category_name " +
                "FROM CATEGORIES c JOIN MOVIES m ON c.id = m.category_id " +
                "WHERE m.id = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movies.class), id);
    }

    public int addMovie(Movies movie){
        jdbcTemplate.update("INSERT INTO MOVIES (title, release_year, director, rating, description, category_id) VALUES (?,?,?,?,?,?)",
                movie.getTitle(), movie.getRelease_year(), movie.getDirector(), movie.getRating(), movie.getDescription(), movie.getCategory_id());
        return 1;
    }

    public Movies updateMovie(int id, Movies movies){
        jdbcTemplate.update("UPDATE MOVIES SET title=?, release_year=?, director=?, rating=?, description=?, category_id=? WHERE id=?",
                movies.getTitle(), movies.getRelease_year(), movies.getDirector(), movies.getRating(), movies.getDescription(), movies.getCategory_id(), id);
        return getMovie(id);
    }

    public int deleteMovie(int id){
        return jdbcTemplate.update("DELETE FROM MOVIES WHERE id=?", id);
    }
}
