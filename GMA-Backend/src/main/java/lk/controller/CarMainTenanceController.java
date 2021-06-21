//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-21
package lk.controller;

import lk.dto.CarMainTenanceDTO;
import lk.exeption.NotFoundException;
import lk.service.CarMainTenanceService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v2/maintenance")
public class CarMainTenanceController {

    @Autowired
    private CarMainTenanceService carMainTenanceService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveMainTenance(@RequestBody CarMainTenanceDTO carMainTenanceDTO){
        if (carMainTenanceDTO.getMainTenanceId().trim().length() <=0){
            throw new NotFoundException("Car Main Tenance id cannot be empty");
        }
        carMainTenanceService.saveCarMainTenance(carMainTenanceDTO);
        return new ResponseEntity(new StandardResponse("201","Done",carMainTenanceDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMainTenance(@PathVariable String id){
        CarMainTenanceDTO carMainTenanceDTO = carMainTenanceService.searchCarMainTenance(id);
        return new ResponseEntity(
                new StandardResponse(
                        "200","Done",carMainTenanceDTO),HttpStatus.OK
        );
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCarMainTenance(@RequestBody CarMainTenanceDTO carMainTenanceDTO) {
        if (carMainTenanceDTO.getMainTenanceId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        carMainTenanceService.updateCarMainTenance(carMainTenanceDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", carMainTenanceDTO), HttpStatus.OK);
    }
}
