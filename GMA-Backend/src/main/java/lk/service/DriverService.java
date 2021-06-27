//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.service;

import lk.dto.DriverDTO;
import java.util.ArrayList;

public interface DriverService {
    void saveDriver(DriverDTO driverDTO);
    DriverDTO searchDriver(String id);
    void updateDriver(DriverDTO driverDTO);
    void deleteDriver(String id);
    ArrayList<DriverDTO> getAllDrivers();
    int getDriverCount();
    String getLastDriverID();
}
