package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class DriverDetails {
    @Id
    private String ddid;
    private String cid;
    private String did;
    private String driverName;
    private String driverPassword;
    private String pickUp;
    private String dropOff;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
    private LocalTime pickUpTime;
    private LocalTime dropOffTime;
}
