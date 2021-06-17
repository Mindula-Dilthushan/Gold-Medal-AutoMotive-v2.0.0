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
public class Car {
    @Id
    private String carId;
    private String carBrand;
    private String carType;
    private int carNmbOfPassengers;
    private String carTransmissionType;
    private String carFuelType;
    private double carPriceForExtraKM;
    private String carRegistrationNumber;
    private String carColour;
    private double carDailyRate;
    private double carMonthlyRate;
    private double carLossDamageWaiver;
    private double carFreeMillagePrice;
    private String carFreeMillageDuration;

//    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Booking> bookingList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
//    private List<CarMainTenance> carMainTenanceList = new ArrayList<>();
}
