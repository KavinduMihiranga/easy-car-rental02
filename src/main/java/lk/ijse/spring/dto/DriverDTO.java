package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String did;
    private String driverName;
    private String driverAge;
    private String driverPassword;
    private String driverLicence;
    private String driverEmail;
    private String driverContactNo;
    private String driverAddress;
    private String driverStatus;
}
