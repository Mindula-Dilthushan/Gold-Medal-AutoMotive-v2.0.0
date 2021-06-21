//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-20
//21-06-21 (Add Method)
package lk.controller;

import lk.dto.BookingDTO;
import lk.exeption.NotFoundException;
import lk.service.BookingService;
import lk.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v2/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBooking(@RequestBody BookingDTO bookingDTO){
        if (bookingDTO.getBookingId().trim().length() <=0){
            throw new NotFoundException("Booking Id cannot be Empty");
        }
        bookingService.saveBooking(bookingDTO);
        return new ResponseEntity(
                new StandardResponse(
                        "201",
                        "Done",
                        bookingDTO
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchBooking(@PathVariable String id){
        BookingDTO bookingDTO = bookingService.searchBooking(id);
        return new ResponseEntity(
                new StandardResponse(
                        "200","Done",bookingDTO
                ),HttpStatus.OK
        );
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBooking(@RequestBody BookingDTO bookingDTO) {
        if (bookingDTO.getBookingId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        bookingService.saveBooking(bookingDTO);
        return new ResponseEntity(new StandardResponse("200", "Done", bookingDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteBooking(@RequestParam String id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }
}
