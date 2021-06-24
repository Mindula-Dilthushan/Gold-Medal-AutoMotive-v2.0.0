//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingReturn {

    @Id
    private String bookingReturnId;
    private Date bookingReturnDate;
    private double bookingReturnNoOfKm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingid",referencedColumnName = "bookingId",nullable = false)
    private Booking booking;
//
//    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
//    private Payment payment;
}
