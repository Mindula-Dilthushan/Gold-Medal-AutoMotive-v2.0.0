//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarMainTenance {
    @Id
    private String mainTenanceId;
    private Date mainTenanceDate;
    private String mainTenanceDescription;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "carid",referencedColumnName = "carId",nullable = false)
//    private Car car;
}
