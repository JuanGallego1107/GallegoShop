package co.edu.cue.GallegoShop.services.impl;

import co.edu.cue.GallegoShop.domain.entities.Customer;
import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.mapper.dtos.CustomerDto;
import co.edu.cue.GallegoShop.mapper.mappers.CartItemMapper;
import co.edu.cue.GallegoShop.mapper.mappers.CustomerMapper;
import co.edu.cue.GallegoShop.mapper.mappers.ProductMapper;
import co.edu.cue.GallegoShop.repositories.CustomerRepository;
import co.edu.cue.GallegoShop.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<CustomerDto> CustomerList() {
        return CustomerMapper.mapFrom((List<Customer>) repo.findAll());
    }

    @Override
    public CustomerDto byId(int id) {
        return CustomerMapper.mapFrom(repo.findById(id).orElseThrow());
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        return CustomerMapper.mapFrom(
                repo.save(CustomerMapper.mapFrom(customer))
        );
    }

    @Override
    public CustomerDto update(CustomerDto customer) {
        return CustomerMapper.mapFrom(
                repo.save(CustomerMapper.mapFrom(customer)));
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

    @Override
    public Customer byIdCustomer(int id) {
        return repo.findById(id).orElseThrow();
    }
}
