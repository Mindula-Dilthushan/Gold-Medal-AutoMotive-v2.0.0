//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DriverDTO {

    private String driverId;
    private String driverName;
    private String driverContact;
    private String driverNIC;
    private String driverEmail;
    private String driverPassword;
}
