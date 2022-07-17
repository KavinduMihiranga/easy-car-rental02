package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private String pid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropOffDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropOffLastDate;
    private String cid;
    private String uid;
    private String did;
    private double rentPrice;
    private double damagingPrice;
    private double discount;
    private double totalPrice;
}
