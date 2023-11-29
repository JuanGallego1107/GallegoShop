package co.edu.cue.GallegoShop.services.impl;

import co.edu.cue.GallegoShop.mapper.dtos.AdminDto;
import co.edu.cue.GallegoShop.mapper.mappers.AdminMapper;
import co.edu.cue.GallegoShop.repositories.AdminRepository;
import co.edu.cue.GallegoShop.services.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repo;

    public AdminServiceImpl(AdminRepository repo) {
        this.repo = repo;
    }

    @Override
    public AdminDto save(AdminDto admin) {
        return AdminMapper.mapFrom(
                repo.save(AdminMapper.mapFrom(admin)));
    }
}
