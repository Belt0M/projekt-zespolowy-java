package pl.Apps.dbMovieapp.Movies.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Apps.dbMovieapp.Movies.Models.Movies;
import pl.Apps.dbMovieapp.Movies.Repositories.MoviesRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesRepository moviesRepository;

    @GetMapping()
    public List<Movies> getAllMovies() {return moviesRepository.getAllMovies();}

    @GetMapping("/{id}")
    public Movies getMovie(@PathVariable("id") int id){return moviesRepository.getMovie(id);}

    @PostMapping()
    public int addMovie(@RequestBody Movies movie) {return moviesRepository.addMovie(movie);}

    @PutMapping("/{id}")
    public Movies editMovie(@PathVariable("id") int id, @RequestBody Movies movie){return moviesRepository.updateMovie(id, movie);}

    @DeleteMapping("/{id}")
    public int deleteMovie(@PathVariable("id") int id){moviesRepository.deleteMovie(id); return 1;}
}
