//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
package lk.service.impl;

import lk.dto.AdminDTO;
import lk.entity.Admin;
import lk.exeption.ValidateException;
import lk.repo.AdminRepo;
import lk.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        if (adminRepo.existsById(adminDTO.getAdminId())) {
            throw new ValidateException("Admin Already Exist");
        }
        System.out.println(adminDTO);
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        Optional<Admin> optionalAdmin = adminRepo.findById(id);
        if (optionalAdmin.isPresent()){
            return modelMapper.map(optionalAdmin.get(),AdminDTO.class);
        }
        return null;
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        if (adminRepo.existsById(adminDTO.getAdminId())) {
            adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        }
    }

    @Override
    public void deleteAdmin(String id) {
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmin() {
        return null;
    }
}
