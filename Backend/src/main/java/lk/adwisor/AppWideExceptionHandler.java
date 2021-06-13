//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.0
package lk.adwisor;

import lk.exception.NotFoundException;
import lk.exception.ValidateException;
import lk.util.StandradResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e){
        return new ResponseEntity(
                new StandradResponse
                        ("500","Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity(
                new StandradResponse(
                        "404","Error", notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public ResponseEntity handleValidationException(ValidateException validateException){
        return new ResponseEntity(
                new StandradResponse(
                        "400","Ërror",validateException.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
