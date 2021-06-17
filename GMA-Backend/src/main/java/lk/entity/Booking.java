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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Booking {

    @Id
    private String bookingId;
    private String bookingDate;
    private String bookingPickDate;
    private String bookingStatus;
    private String bookingNote;
    private String bookingReturnDate;

    @ManyToOne
    @JoinColumn(name = "custid", referencedColumnName = "CustomerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carid", referencedColumnName = "carId", nullable = false)
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverid", referencedColumnName = "DriverId",nullable = false)
    private Driver driver;

}
