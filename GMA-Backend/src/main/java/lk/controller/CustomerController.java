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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/v2/customer")
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
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{customerEmail}/{customerPassword}")
    public ResponseEntity login(@PathVariable("customerEmail") String val1, @PathVariable("customerPassword") String val2) {
        CustomerDTO customerDTO = customerService.customerLogin(val1,val2);
        if ( customerDTO!= null) {
            customerDTO.setCustomerPassword("");
            StandardResponse response = new StandardResponse("200", "customer", customerDTO);
            return new ResponseEntity(response, HttpStatus.OK);
        } else {
            StandardResponse response = new StandardResponse("500", "Error", null);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
