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
public class Customer {

    @Id
    private String CustomerId;
    private String CustomerName;
    private String CustomerAddress;
    private String CustomerContact;
    private String CustomerEmail;
    private String CustomerNIC;
    private String CustomerDrivingLIC;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookingList = new ArrayList<>();
}
