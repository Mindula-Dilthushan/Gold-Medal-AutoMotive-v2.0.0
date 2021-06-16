package lk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

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
}
