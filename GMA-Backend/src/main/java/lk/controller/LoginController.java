//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-21
package lk.controller;

import lk.dto.LoginDTO;
import lk.exeption.NotFoundException;
import lk.service.LoginService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v2/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveLogin(@RequestBody LoginDTO loginDTO){
        if (loginDTO.getLoginEmail().trim().length() <=0){
            throw new NotFoundException("Login id cannot be empty");
        }
        loginService.saveLogin(loginDTO);
        return new ResponseEntity(new StandardResponse("201","Done",loginDTO), HttpStatus.CREATED);
    }
    }
