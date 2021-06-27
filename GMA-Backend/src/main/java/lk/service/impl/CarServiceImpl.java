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
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (carRepo.existsById(carDTO.getCarId())) {
            carRepo.save(modelMapper.map(carDTO, Car.class));
        }
    }

    @Override
    public void deleteCars(String id) {
        if (!carRepo.existsById(id)) {
            throw new ValidateException("No Car for Delete..!");
        }
        carRepo.deleteById(id);
    }

    @Override
    public CarDTO searchCars(String id) {
        Optional<Car> carOptional = carRepo.findById(id);
        if (carOptional.isPresent()){
            return modelMapper.map(carOptional.get(), CarDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> carList = carRepo.findAll();
        return modelMapper.map(carList, new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public int getCarCount() {
        return carRepo.getCarCount();
    }

    @Override
    public String getLastCarID() {
        String lastID = carRepo.getCarLastID();
        if (lastID != null) {
            String[] split = lastID.split("CR");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "CR00" + id;
            else if (id < 100) return "CR0" + id;
            else return "CR" + id;
        }else{
            return "CR001";
        }
    }

    @Override
    public String getCarRegNo() {
        String lastID = carRepo.getCarRegNoID();
        if (lastID != null) {
            String[] split = lastID.split("CRN");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "CRN00" + id;
            else if (id < 100) return "CRN0" + id;
            else return "CRN" + id;
        } else {
            return "CRN001";
        }
    }
}
