package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AdminDTO {
    private String aid;
    private String password;
    private String username;
    private String name;
    private String email;
    private String contactNo;
}
