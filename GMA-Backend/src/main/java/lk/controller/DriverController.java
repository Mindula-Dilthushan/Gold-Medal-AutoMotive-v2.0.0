//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.controller;

import lk.dto.DriverDTO;
import lk.exeption.NotFoundException;
import lk.service.DriverService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/v2/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveDriver(@RequestBody DriverDTO driverDTO){
        if (driverDTO.getDriverId().trim().length() <=0){
            throw new NotFoundException("Driver id cannot be empty");
        }
        driverService.saveDriver(driverDTO);
        return new ResponseEntity(new StandardResponse("201","Done",driverDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchDriver(@PathVariable String id){
        DriverDTO driverDTO = driverService.searchDriver(id);
        return new ResponseEntity(
                new StandardResponse(
                        "200","Done",driverDTO),HttpStatus.OK
        );
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriver(@RequestBody DriverDTO driverDTO) {
        if (driverDTO.getDriverId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        driverService.updateDriver(driverDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteDriver(@RequestParam String id) {
        driverService.deleteDriver(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDrivers() {
        ArrayList<DriverDTO> driverDTOArrayList = driverService.getAllDrivers();
        return new ResponseEntity(new StandardResponse("200", "Done", driverDTOArrayList), HttpStatus.OK);
    }
    @GetMapping("driverCount")
    public ResponseEntity getCustomerCount(){
        int count = driverService.getDriverCount();
        return new ResponseEntity(new StandardResponse("200","Done",count),HttpStatus.OK);
    }
    @GetMapping("lastDriverId")
    public ResponseEntity getLastCarId(){
        String id = driverService.getLastDriverID();
        return new ResponseEntity(
                new StandardResponse("200","Done",id),HttpStatus.OK);
    }
}
