package co.edu.cue.GallegoShop.services;


import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> ProductList();
    ProductDto byId(int id);
    Product byIdProduct(int id) throws Exception;
    ProductDto save(ProductDto product);
    ProductDto update(ProductDto product);
    void deleteById(int id);
    }
