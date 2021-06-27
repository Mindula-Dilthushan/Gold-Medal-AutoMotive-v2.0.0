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
import java.util.ArrayList;

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

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCar(@PathVariable String id){
        CarDTO carDTO = carServices.searchCars(id);
        return new ResponseEntity(
                new StandardResponse(
                        "200","Done",carDTO),HttpStatus.OK
        );
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCars(@RequestBody CarDTO carDTO) {
        if (carDTO.getCarId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        carServices.updateCars(carDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", carDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCars(@RequestParam String id) {
        carServices.deleteCars(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCars() {
        ArrayList<CarDTO> carDTOArrayList = carServices.getAllCars();
        return new ResponseEntity(new StandardResponse("200", "Done", carDTOArrayList), HttpStatus.OK);
    }
    @GetMapping("carCount")
    public ResponseEntity getCustomerCount(){
        int count = carServices.getCarCount();
        return new ResponseEntity(new StandardResponse("200","Done",count),HttpStatus.OK);
    }
    @GetMapping("lastCarId")
    public ResponseEntity getLastCarId(){
        String id = carServices.getLastCarID();
        return new ResponseEntity(
                new StandardResponse("200","Done",id),HttpStatus.OK);
    }
    @GetMapping("lastCarRegNo")
    public ResponseEntity getCarRegNo(){
        String id = carServices.getCarRegNo();
        return new ResponseEntity(
                new StandardResponse("200","Done",id),HttpStatus.OK);
    }
}
