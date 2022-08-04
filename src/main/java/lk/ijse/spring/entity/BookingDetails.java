package lk.ijse.spring.entity;

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
public class BookingDetails {
    @Id
    private String bdid;
    private String uid;
    private String userName;
    private String userEmail;
    private String userAccountNo;
    private String cid;
    private String did;
    private String pickUp;
    private String dropOff;
    private String driverNeed;
    private LocalDate pickUpDate;
    private LocalDate dropOffDate;
    private LocalTime pickUpTime;
    private LocalTime dropOffTime;
    private double rentPrice;


}
