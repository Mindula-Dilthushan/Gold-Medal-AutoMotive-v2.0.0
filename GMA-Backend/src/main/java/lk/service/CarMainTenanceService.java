//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-19
package lk.service;

import lk.dto.CarMainTenanceDTO;
import java.util.ArrayList;

public interface CarMainTenanceService {
    void saveCarMainTenance(CarMainTenanceDTO carMainTenanceDTO);
    void deleteCarMainTenance(String id);
    void updateCarMainTenance(CarMainTenanceDTO carMainTenanceDTO);
    CarMainTenanceDTO searchCarMainTenance(String id);
    ArrayList<CarMainTenanceDTO> getCarMainTenance();

}
