package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.DriverDetailsDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DriverDetailsService {
    void saveDriverDetails(DriverDetailsDTO dto);
    void deleteDriverDetails(String ddid);
    void updateDriverDetails(DriverDetailsDTO dto);
    DriverDetailsDTO searchDriverDetails(String ddid);
    List<DriverDetailsDTO> getAllDriverDetails();
}
