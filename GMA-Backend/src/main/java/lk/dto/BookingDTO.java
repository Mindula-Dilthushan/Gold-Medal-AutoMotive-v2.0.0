//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bookingId;
    private String bookingDate;
    private String bookingPickDate;
    private String bookingStatus;
    private String bookingNote;
    private String bookingReturnDate;
    private String customerId;
    private String carId;
    private String driverId;
}
