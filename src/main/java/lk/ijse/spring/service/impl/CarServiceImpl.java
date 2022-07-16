package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void saveCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getCid())){
            carRepo.save(mapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("Car Already Exist..!");
        }
    }

    @Override
    public void deleteCar(String cid) {
        if (carRepo.existsById(cid)){
            carRepo.deleteById(cid);
        }else {
            throw new RuntimeException("Please check the Car ID.. No Such Car..!");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (carRepo.existsById(dto.getCid())){
            carRepo.save(mapper.map(dto,Car.class));
        }else {
            throw new RuntimeException("No Such Car To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CarDTO searchCar(String cid) {
        if (carRepo.existsById(cid)){
            return mapper.map(carRepo.findById(cid).get(), CarDTO.class);
        }else {
            throw new RuntimeException("No Admin For " + cid + " ..!");
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
        return mapper.map(carRepo.findAll(),new TypeToken<List<CarDTO>>(){}.getType());
    }
}
