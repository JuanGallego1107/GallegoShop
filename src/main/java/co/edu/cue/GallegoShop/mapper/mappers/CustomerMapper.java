package co.edu.cue.GallegoShop.mapper.mappers;



import co.edu.cue.GallegoShop.domain.entities.Customer;
import co.edu.cue.GallegoShop.mapper.dtos.CustomerDto;

import java.util.List;

public class CustomerMapper {
    public static CustomerDto mapFrom(Customer source){
        return new CustomerDto(source.getId(),
                source.getName(),
                source.getEmail(),
                source.getAddress());
    }
    public static Customer mapFrom(CustomerDto source){
        return new Customer(source.customerId(),
                source.customerName(),
                source.customerEmail(),
                source.adress()
        );
    }
    public static List<CustomerDto> mapFrom(List<Customer> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
