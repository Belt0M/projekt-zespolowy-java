package pl.Apps.dbMovieapp.Movies.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Apps.dbMovieapp.Movies.Models.Rentals;
import pl.Apps.dbMovieapp.Movies.Repositories.RentalsRepository;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalsController {
    @Autowired
    private RentalsRepository rentalsRepository;

    @GetMapping()
    public List<Rentals> getAllUsers() {return rentalsRepository.getAllRentals();}

    @GetMapping("/{id}")
    public Rentals getRental(@PathVariable("id") int id){return rentalsRepository.getRental(id);}

    @PostMapping()
    public int addRental(@RequestBody List<Rentals> rental) {return rentalsRepository.addRental(rental);}

    @PutMapping("/{id}")
    public Rentals editRental(@PathVariable("id") int id, @RequestBody Rentals rental){return rentalsRepository.updateRental(id, rental);}

    @DeleteMapping("/{id}")
    public int deleteRental(@PathVariable("id") int id){rentalsRepository.deleteRental(id); return 1;}
}
