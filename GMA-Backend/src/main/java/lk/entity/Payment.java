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
public class Payment {
    @Id
    private String paymentId;
    private Date paymentDate;
    private String paymentType;
    private double paymentAmount;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "bookingreturnid",referencedColumnName = "bookingReturnId",nullable = false)
//    private BookingReturn bookingReturn;

}
