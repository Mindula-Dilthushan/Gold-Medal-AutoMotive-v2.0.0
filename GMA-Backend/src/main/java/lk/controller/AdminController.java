//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
package lk.controller;

import lk.dto.AdminDTO;
import lk.exeption.NotFoundException;
import lk.service.AdminService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/v2/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String getAdmin() {
        return "get Admin";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveAdmin(@RequestBody AdminDTO adminDTO) {
        if (adminDTO.getAdminId().trim().length() <= 0) {
            throw new NotFoundException("Admin id cannot be empty");
        }
        adminService.saveAdmin(adminDTO);
        return new ResponseEntity(new StandardResponse("201", "Done",adminDTO), HttpStatus.CREATED);
    }
}
