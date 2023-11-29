package co.edu.cue.GallegoShop.services.impl;


import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;
import co.edu.cue.GallegoShop.mapper.mappers.ProductMapper;
import co.edu.cue.GallegoShop.repositories.ProductRepository;
import co.edu.cue.GallegoShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<ProductDto> ProductList() {
        return ProductMapper.mapFrom((List<Product>) repo.findAll());
    }

    @Override
    public ProductDto byId(int id) {
        return ProductMapper.mapFrom(repo.findById(id).orElseThrow());
    }

    @Override
    public Product byIdProduct(int id) throws Exception {
       return repo.findById(id).orElseThrow();
    }

    @Override
    public ProductDto save(ProductDto product) {
        return ProductMapper.mapFrom(
                repo.save(ProductMapper.mapFrom(product))
        );
    }

    @Override
    public ProductDto update(ProductDto product) {
        return ProductMapper.mapFrom(
                repo.save(ProductMapper.mapFrom(product))
        );
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
