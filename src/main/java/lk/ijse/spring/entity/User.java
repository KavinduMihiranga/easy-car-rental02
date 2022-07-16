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
public class User {
    @Id
    private String uid;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userContactNo;
    private String userIdentityCardImg;
    private String userDrivingLicenceImg;
}
