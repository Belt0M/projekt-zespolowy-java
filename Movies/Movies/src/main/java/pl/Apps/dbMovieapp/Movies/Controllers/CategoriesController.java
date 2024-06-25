package pl.Apps.dbMovieapp.Movies.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Apps.dbMovieapp.Movies.Models.Categories;
import pl.Apps.dbMovieapp.Movies.Repositories.CategoriesRepository;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesRepository categoriesRepository;

    @GetMapping()
    public List<Categories> getAllCategories() {return categoriesRepository.getAllCategories();}

    @GetMapping("/{id}")
    public Categories getCategory(@PathVariable("id") int id){return categoriesRepository.getCategory(id);}

    @PostMapping()
    public int addCategory(@RequestBody List<Categories> category) {return categoriesRepository.addCategory(category);}

    @PutMapping("/{id}")
    public Categories editCategory(@PathVariable("id") int id, @RequestBody Categories category){return categoriesRepository.updateCategory(id, category);}

    @DeleteMapping("/{id}")
    public int deleteMovie(@PathVariable("id") int id){categoriesRepository.deleteCategory(id); return 1;}
}
