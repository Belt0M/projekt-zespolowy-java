package pl.Apps.dbMovieapp.Movies.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import pl.Apps.dbMovieapp.Movies.Models.Categories;

import java.util.List;

@Repository
public class CategoriesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Categories> getAllCategories() {
        return jdbcTemplate.query("SELECT * from CATEGORIES", BeanPropertyRowMapper.newInstance(Categories.class));
    }

    public Categories getCategory(int id){
        return jdbcTemplate.queryForObject("SELECT id, name FROM CATEGORIES WHERE id=?",
                BeanPropertyRowMapper.newInstance(Categories.class), id);
    }

    public int addCategory(List<Categories> category){
        category.forEach(categories -> jdbcTemplate.update("INSERT INTO CATEGORIES (name) VALUES (?)",
                categories.getName()
        ));
        return 1;
    }

    public Categories updateCategory(int id, Categories category){
        jdbcTemplate.update("UPDATE CATEGORIES SET name=? WHERE id=?", category.getName(), id);
        return getCategory(id);
    }

    public int deleteCategory(int id){
        return jdbcTemplate.update("DELETE FROM CATEGORIES WHERE id=?", id);
    }

}
