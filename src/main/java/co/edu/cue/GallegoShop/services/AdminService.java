package co.edu.cue.GallegoShop.services;

import co.edu.cue.GallegoShop.domain.entities.Admin;
import co.edu.cue.GallegoShop.mapper.dtos.AdminDto;
import co.edu.cue.GallegoShop.mapper.dtos.CustomerDto;

public interface AdminService {
    AdminDto save(AdminDto admin);
}
