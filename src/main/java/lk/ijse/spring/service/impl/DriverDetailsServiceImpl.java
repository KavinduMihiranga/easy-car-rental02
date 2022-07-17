package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.DriverDetailsDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.DriverDetails;
import lk.ijse.spring.repo.DriverDetailsRepo;
import lk.ijse.spring.service.DriverDetailsService;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverDetailsServiceImpl implements DriverDetailsService {
    @Autowired
    DriverDetailsRepo driverDetailsRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void saveDriverDetails(DriverDetailsDTO dto) {
        if (!driverDetailsRepo.existsById(dto.getDdid())){
            driverDetailsRepo.save(modelMapper.map(dto, DriverDetails.class));
        }else {
            throw new RuntimeException("DriverDetails Already Exist..!");
        }
    }

    @Override
    public void deleteDriverDetails(String ddid) {
        if (driverDetailsRepo.existsById(ddid)){
            driverDetailsRepo.deleteById(ddid);
        }else {
            throw new RuntimeException("Please check the DriverDetails ID.. No Such DriverDetails..!");
        }
    }

    @Override
    public void updateDriverDetails(DriverDetailsDTO dto) {
        if (driverDetailsRepo.existsById(dto.getDdid())){
            driverDetailsRepo.save(modelMapper.map(dto,DriverDetails.class));
        }else {
            throw new RuntimeException("No Such DriverDetails To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDetailsDTO searchDriverDetails(String ddid) {
        if (driverDetailsRepo.existsById(ddid)){
            return modelMapper.map(driverDetailsRepo.findById(ddid).get(), DriverDetailsDTO.class);
        }else {
            throw new RuntimeException("No DriverDetails For " + ddid + " ..!");
        }
    }

    @Override
    public List<DriverDetailsDTO> getAllDriverDetails() {
        return modelMapper.map(driverDetailsRepo.findAll(),new TypeToken<List<DriverDetailsDTO>>(){}.getType());

    }
}
