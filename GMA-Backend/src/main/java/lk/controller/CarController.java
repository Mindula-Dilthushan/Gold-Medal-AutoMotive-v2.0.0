//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.controller;

import lk.dto.CarDTO;
import lk.exeption.NotFoundException;
import lk.service.CarServices;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v2/car")
public class CarController {

    @Autowired
    private CarServices carServices;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCar(@RequestBody CarDTO carDTO) {
        if (carDTO.getCarId().trim().length() <= 0) {
            throw new NotFoundException("Car id cannot be empty");
        }
        carServices.saveCars(carDTO);
        return new ResponseEntity(new StandardResponse("201", "Done",carDTO), HttpStatus.CREATED);
    }
}
