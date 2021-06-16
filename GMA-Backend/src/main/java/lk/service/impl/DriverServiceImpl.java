//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.service.impl;

import lk.dto.DriverDTO;
import lk.entity.Customer;
import lk.entity.Driver;
import lk.exeption.ValidateException;
import lk.repo.DriverRepo;
import lk.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDriverId())){
            throw new ValidateException("Driver Already Exist");
        }
        System.out.println(driverDTO);
        driverRepo.save(
                modelMapper.map(driverDTO, Driver.class)
        );
    }

    @Override
    public DriverDTO searchDriver(String id) {
        return null;
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {

    }

    @Override
    public void deleteDriver(String id) {

    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return null;
    }
}
