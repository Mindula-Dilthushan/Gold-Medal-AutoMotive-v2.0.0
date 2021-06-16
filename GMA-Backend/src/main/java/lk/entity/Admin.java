//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
package lk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Admin {
    @Id
    private String adminId;
    private String adminEmail;
    private String adminName;
    private String adminPassword;
}
