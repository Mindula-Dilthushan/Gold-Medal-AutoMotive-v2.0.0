//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Driver {

    @Id
    private String driverId;
    private String driverName;
    private String driverContact;
    private String driverNIC;
    private String driverEmail;
    private String driverPassword;

//    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Booking> bookingList = new ArrayList<>();

}
