//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class BookingReturnDTO {

    private String bookingReturnId;
    private Date bookingReturnDate;
    private double bookingReturnNoOfKm;
}
