//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-21
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
public class Login {
    @Id
    private String loginEmail;
    private String loginFName;
    private String loginLName;
    private String loginPassword;
}
