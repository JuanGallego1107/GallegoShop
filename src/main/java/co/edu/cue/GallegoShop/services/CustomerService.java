package co.edu.cue.GallegoShop.services;


import co.edu.cue.GallegoShop.domain.entities.Customer;
import co.edu.cue.GallegoShop.mapper.dtos.CartItemDto;
import co.edu.cue.GallegoShop.mapper.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> CustomerList();
    CustomerDto byId(int id);
    CustomerDto save(CustomerDto customer);
    CustomerDto update(CustomerDto customer);
    void deleteById(int id);
    Customer byIdCustomer(int id);
}
