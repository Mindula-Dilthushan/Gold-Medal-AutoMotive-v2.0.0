//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.service;

import lk.dto.CarDTO;
import java.util.ArrayList;

public interface CarServices {
    void saveCars(CarDTO carDTO);
    CarDTO searchCars(String id);
    void updateCars(CarDTO adminDTO);
    void deleteCars(String id);
    ArrayList<CarDTO> getAllCars();
    int getCarCount();
    String getLastCarID();
    String getCarRegNo();
}
