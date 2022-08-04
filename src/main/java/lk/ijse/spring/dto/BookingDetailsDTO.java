package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingDetailsDTO {
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropOffDate;
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime pickUpTime;
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime dropOffTime;
    private double rentPrice;
}
