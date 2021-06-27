//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.service.impl;

import lk.dto.DriverDTO;
import lk.entity.Driver;
import lk.exeption.ValidateException;
import lk.repo.DriverRepo;
import lk.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Driver> driverOptional = driverRepo.findById(id);
        if (driverOptional.isPresent()){
            return modelMapper.map(driverOptional.get(), DriverDTO.class);
        }
        return null;
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDriverId())){
            driverRepo.save(modelMapper.map(driverDTO,Driver.class));
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (!driverRepo.existsById(id)){
            throw new ValidateException("No Driver for Delete..!");
        }
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver> driverList = driverRepo.findAll();
        return modelMapper.map(driverList,new TypeToken<ArrayList<DriverDTO>>(){
        }.getType());
    }

    @Override
    public int getDriverCount() {
        return driverRepo.getDriverCount();
    }

    @Override
    public String getLastDriverID() {
        String lastID = driverRepo.getDriverLastID();
        if (lastID != null) {
            String[] split = lastID.split("D");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "D00" + id;
            else if (id < 100) return "D0" + id;
            else return "D" + id;
        }else{
            return "D001";
        }
    }
}
