//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-21
package lk.controller;

import lk.dto.PaymentDTO;
import lk.exeption.NotFoundException;
import lk.service.PaymentService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v2/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity savePayment(@RequestBody PaymentDTO paymentDTO){
        if (paymentDTO.getPaymentId().trim().length() <=0){
            throw new NotFoundException("Payment id cannot be empty");
        }
        paymentService.savePayment(paymentDTO);
        return new ResponseEntity(new StandardResponse("201","Done",paymentDTO), HttpStatus.CREATED);
    }
}
