package pe.edu.tecsup.springbootapp.services;

import pe.edu.tecsup.springbootapp.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories() throws Exception;
}
