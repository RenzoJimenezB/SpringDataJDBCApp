package pe.edu.tecsup.springbootapp.repositories;

import pe.edu.tecsup.springbootapp.entities.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll() throws Exception;
}
