//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.controller;

import lk.dto.CustomerDTO;
import lk.exeption.NotFoundException;
import lk.service.CustomerService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("v2/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getCustomerId().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity(new StandardResponse("201", "Done", customerDTO), HttpStatus.CREATED);
    }


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        System.out.println("customerDTO controller= " + customerDTO);
        return new ResponseEntity(
                new StandardResponse(
                        "200", "Done", customerDTO), HttpStatus.OK
        );

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getCustomerId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomer(@RequestParam String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomers() {
        ArrayList<CustomerDTO> customerDTOArrayList = customerService.getAllCustomers();
        System.out.println("all " + customerDTOArrayList);
        return new ResponseEntity(new StandardResponse("200", "Done", customerDTOArrayList), HttpStatus.OK);
    }

    @GetMapping("customerCount")
    public ResponseEntity getCustomerCount(){
        int count = customerService.getCustomerCount();
        return new ResponseEntity(new StandardResponse("200","Done",count),HttpStatus.OK);
    }
    @GetMapping("lastCustomerId")
    public ResponseEntity getLastCustomerId(){
        String id = customerService.getLastCustomerID();
        return new ResponseEntity(
                new StandardResponse("200","Done",id),HttpStatus.OK);
    }
    @GetMapping("custDLIC")
    public ResponseEntity getLastCustomerDLIC(){
        String id = customerService.getCustomerDLIC();
        return new ResponseEntity(
                new StandardResponse("200","Done",id),HttpStatus.OK);
    }


}
