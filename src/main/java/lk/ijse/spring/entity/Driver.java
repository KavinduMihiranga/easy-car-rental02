package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Driver {
    @Id
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
