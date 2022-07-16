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
public class Car {
    @Id
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
