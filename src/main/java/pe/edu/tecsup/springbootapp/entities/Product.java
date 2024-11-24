package pe.edu.tecsup.springbootapp.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Product {
    private Long id;
    private Long categoryId;
    private Category category;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String image_name;
    private String image_type;
    private Long image_size;
    private Integer state;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

}
