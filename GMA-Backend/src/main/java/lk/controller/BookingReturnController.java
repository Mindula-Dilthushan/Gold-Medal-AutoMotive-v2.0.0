package lk.controller;

import lk.dto.BookingReturnDTO;
import lk.exeption.NotFoundException;
import lk.service.BookingReturnService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v2/bookingreturn")
public class BookingReturnController {

    @Autowired
    private BookingReturnService bookingReturnService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBookingReturn(@RequestBody BookingReturnDTO bookingReturnDTO) {
        if (bookingReturnDTO.getBookingReturnId().trim().length() <= 0) {
            throw new NotFoundException("Booking Return id cannot be empty");
        }
        bookingReturnService.saveBookingReturn(bookingReturnDTO);
        return new ResponseEntity(new StandardResponse("201", "Done",bookingReturnDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchBookingReturn(@PathVariable String id){
        BookingReturnDTO bookingReturnDTO  = bookingReturnService.searchBookingReturn(id);
        return new ResponseEntity(
                new StandardResponse(
                        "200","Done",bookingReturnDTO),HttpStatus.OK
        );
    }
}
