package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UserDTO dto) {
        if (!userRepo.existsById(dto.getUid())){
            userRepo.save(mapper.map(dto, User.class));
        }else {
            throw new RuntimeException("User Already Exist..!");
        }

    }

    @Override
    public void deleteUser(String uid) {
        if (userRepo.existsById(uid)){
            userRepo.deleteById(uid);
        }else {
            throw new RuntimeException("Please check the User ID.. No Such User..!");
        }
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUid())){
            userRepo.save(mapper.map(dto,User.class));
        }else {
            throw new RuntimeException("No Such User To Update..! Please Check the ID..!");
        }
    }

    @Override
    public UserDTO searchUser(String uid) {
        if (userRepo.existsById(uid)){
            return mapper.map(userRepo.findById(uid).get(), UserDTO.class);
        }else {
            throw new RuntimeException("No Admin For " + uid + " ..!");
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        return mapper.map(userRepo.findAll(),new TypeToken<List<UserDTO>>(){}.getType());
    }
}
