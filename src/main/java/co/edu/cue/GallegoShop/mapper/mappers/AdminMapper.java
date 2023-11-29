package co.edu.cue.GallegoShop.mapper.mappers;

import co.edu.cue.GallegoShop.domain.entities.Admin;
import co.edu.cue.GallegoShop.mapper.dtos.AdminDto;

import java.util.List;

public class AdminMapper {
    public static AdminDto mapFrom(Admin source){
        return new AdminDto(source.getId(),
                source.getUsername(),
                source.getPassword()
        );
    }
    public static Admin mapFrom(AdminDto source){
        return new Admin(source.id(),
                source.username(),
                source.password()
        );
    }
    public static List<AdminDto> mapFrom(List<Admin> source) {
        return source.parallelStream().map(e-> mapFrom(e)).toList();
    }
}
