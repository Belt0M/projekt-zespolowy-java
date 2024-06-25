package pl.Apps.dbMovieapp.Movies.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Apps.dbMovieapp.Movies.Models.Users;
import pl.Apps.dbMovieapp.Movies.Repositories.UsersRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping()
    public List<Users> getAllUsers() {return usersRepository.getAllUsers();}

    @GetMapping("/{id}")
    public Users getUser(@PathVariable("id") int id){return usersRepository.getUser(id);}

    @PostMapping()
    public int addUser(@RequestBody List<Users> user) {return usersRepository.addUser(user);}

    @PutMapping("/{id}")
    public Users editUser(@PathVariable("id") int id, @RequestBody Users user){return usersRepository.updateUser(id, user);}

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable("id") int id){usersRepository.deleteUser(id); return 1;}
}
