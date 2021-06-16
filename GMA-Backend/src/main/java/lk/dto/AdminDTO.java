//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
package lk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String adminId;
    private String adminEmail;
    private String adminName;
    private String adminPassword;
}
