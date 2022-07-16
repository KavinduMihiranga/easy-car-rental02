package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String cid;
    private String numberOfPassengers;
    private String transmissionType;
    private String color;
    private String registrationNumber;
    private String fuelType;
    private String brand;
    private String carType;
    private String status;
    private String img;
    private double priceForTheExtraKm;
    private double freeMileageForDay;
    private double freeMileageForMonth;
    private double priceForTheDailyRate;
    private double priceForTheMonthlyRate;
    private double damageWaver;
    private double runKm;
}
