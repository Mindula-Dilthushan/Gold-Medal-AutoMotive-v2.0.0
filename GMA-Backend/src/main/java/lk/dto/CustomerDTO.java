package lk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CustomerDTO {

    private String CustomerId;
    private String CustomerName;
    private String CustomerAddress;
    private String CustomerContact;
    private String CustomerEmail;
    private String CustomerNIC;
    private String CustomerDrivingLIC;
}
