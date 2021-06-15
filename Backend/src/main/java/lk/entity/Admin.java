//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.0
package lk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    @Id
    private String adminId;
    private String adminName;
    private String adminAddress;
    private double adminSalary;
}
