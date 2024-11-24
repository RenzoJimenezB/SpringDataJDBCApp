package pe.edu.tecsup.springbootapp.entities;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String name;
    private Integer order;
}
