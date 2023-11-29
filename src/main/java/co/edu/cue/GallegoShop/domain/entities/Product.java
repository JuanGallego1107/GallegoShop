package co.edu.cue.GallegoShop.domain.entities;

import co.edu.cue.GallegoShop.domain.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String description;
    private Integer price;
    private Integer stock;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String imageUrl;

}
