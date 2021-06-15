//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.0
package lk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {
    private String adminId;
    private String adminName;
    private String adminAddress;
    private double adminSalary;
}
