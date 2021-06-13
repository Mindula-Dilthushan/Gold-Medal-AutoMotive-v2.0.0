//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.0
package lk.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/gma/v2/admin")
public class AdminController {

    @GetMapping
    public String getAdmin(){
        return "get Admin";
    }
}
