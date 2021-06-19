//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-19
package lk.service.impl;

import lk.dto.CarMainTenanceDTO;
import lk.service.CarMainTenanceService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarMainTenanceServiceImpl implements CarMainTenanceService {

    @Override
    public void saveCarMainTenance(CarMainTenanceDTO carMainTenanceDTO) {

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
