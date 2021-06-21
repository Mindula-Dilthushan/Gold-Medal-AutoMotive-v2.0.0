//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-21
package lk.service.impl;

import lk.dto.LoginDTO;
import lk.entity.Login;
import lk.exeption.ValidateException;
import lk.repo.LoginRepo;
import lk.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveLogin(LoginDTO loginDTO) {
        if (loginRepo.existsById(loginDTO.getLoginEmail())){
            throw new ValidateException("Login Already Exist");
        }
        System.out.println(loginDTO);
        loginRepo.save(
                modelMapper.map(loginDTO, Login.class)
        );
    }

    @Override
    public void deleteLogin(String id) {
        if (!loginRepo.existsById(id)){
            throw new ValidateException("No Login for Delete..!");
        }
    }

    @Override
    public void updateLogin(LoginDTO loginDTO) {
        if (loginRepo.existsById(loginDTO.getLoginEmail())){
            loginRepo.save(modelMapper.map(loginDTO, Login.class));
        }
    }

    @Override
    public LoginDTO searchLogin(String id) {
        return null;
    }

    @Override
    public ArrayList<LoginDTO> getAllLogs() {
        return null;
    }
}
