package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getDid())){
            driverRepo.save(mapper.map(dto, Driver.class));
        }else {
            throw new RuntimeException("Driver Already Exist..!");
        }

    }

    @Override
    public void deleteDriver(String did) {
        if (driverRepo.existsById(did)){
            driverRepo.deleteById(did);
        }else {
            throw new RuntimeException("Please check the Driver ID.. No Such Driver..!");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDid())){
            driverRepo.save(mapper.map(dto,Driver.class));
        }else {
            throw new RuntimeException("No Such Driver To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDTO searchDriver(String did) {
        if (driverRepo.existsById(did)){
            return mapper.map(driverRepo.findById(did).get(), DriverDTO.class);
        }else {
            throw new RuntimeException("No Driver For " + did + " ..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return mapper.map(driverRepo.findAll(),new TypeToken<List<DriverDTO>>(){}.getType());
    }
}
