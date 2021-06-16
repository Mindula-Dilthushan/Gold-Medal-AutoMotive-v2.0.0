//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.service.impl;

import lk.dto.CarDTO;
import lk.entity.Car;
import lk.exeption.ValidateException;
import lk.repo.CarRepo;
import lk.service.CarServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarServices {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCars(CarDTO carDTO) {
        if (carRepo.existsById(carDTO.getCarId())) {
            throw new ValidateException("Car Already Exist");
        }
        System.out.println(carDTO);
        carRepo.save(modelMapper.map(carDTO, Car.class));
    }

    @Override
    public void updateCars(CarDTO carDTO) {

    }

    @Override
    public void deleteCars(String id) {

    }

    @Override
    public CarDTO searchCars(String id) {
        return null;
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return null;
    }
}
