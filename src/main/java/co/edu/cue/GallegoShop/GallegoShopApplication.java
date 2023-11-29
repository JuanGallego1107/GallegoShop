package co.edu.cue.GallegoShop;

import co.edu.cue.GallegoShop.domain.entities.Product;
import co.edu.cue.GallegoShop.mapper.dtos.ProductDto;
import co.edu.cue.GallegoShop.repositories.ProductRepository;
import co.edu.cue.GallegoShop.services.ProductService;
import co.edu.cue.GallegoShop.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class GallegoShopApplication{

	public static void main(String[] args) {
		SpringApplication.run(GallegoShopApplication.class, args);

	}

}
