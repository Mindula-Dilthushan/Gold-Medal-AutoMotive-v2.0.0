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
    private String customerId;
    private String carId;
    private String driverId;

//    @ManyToOne
//    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
//    private Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "carId", referencedColumnName = "carId", nullable = false)
//    private Car car;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "driverId", referencedColumnName = "driverId",nullable = false)
//    private Driver driver;

//    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
//    private BookingReturn bookingReturn;

//    public Booking(String bookingId, String bookingDate, String bookingPickDate, String bookingStatus, String bookingNote, String bookingReturnDate, Customer customer, Car car, Driver driver) {
//        this.bookingId = bookingId;
//        this.bookingDate = bookingDate;
//        this.bookingPickDate = bookingPickDate;
//        this.bookingStatus = bookingStatus;
//        this.bookingNote = bookingNote;
//        this.bookingReturnDate = bookingReturnDate;
//        this.customer = customer;
//        this.car = car;
//        this.driver = driver;
//    }
}
