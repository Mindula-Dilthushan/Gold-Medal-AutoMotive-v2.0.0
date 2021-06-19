//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-19
package lk.service.impl;

import lk.dto.CarMainTenanceDTO;
import lk.entity.CarMainTenance;
import lk.exeption.ValidateException;
import lk.repo.CarMainTenanceRepo;
import lk.service.CarMainTenanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarMainTenanceServiceImpl implements CarMainTenanceService {

    @Autowired
    private CarMainTenanceRepo carMainTenanceRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCarMainTenance(CarMainTenanceDTO carMainTenanceDTO) {
        if (carMainTenanceRepo.existsById(carMainTenanceDTO.getMainTenanceId())){
            throw new ValidateException("Payment Already Exist");
        }
        System.out.println(carMainTenanceDTO);
        carMainTenanceRepo.save(
                modelMapper.map(carMainTenanceDTO, CarMainTenance.class)
        );
    }

    @Override
    public void deleteCarMainTenance(String id) {

    }

    @Override
    public void updateCarMainTenance(CarMainTenanceDTO carMainTenanceDTO) {

    }

    @Override
    public CarMainTenanceDTO searchCarMainTenance(String id) {
        return null;
    }

    @Override
    public ArrayList<CarMainTenanceDTO> getCarMainTenance() {
        return null;
    }
}
