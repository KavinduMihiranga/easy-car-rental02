package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void savePayment(PaymentDTO dto) {
        if (!paymentRepo.existsById(dto.getPid())){
            paymentRepo.save(modelMapper.map(dto, Payment.class));
        }else {
            throw new RuntimeException("Payment Already Exist..!");
        }
    }

    @Override
    public void deletePayment(String pid) {
        if (paymentRepo.existsById(pid)){
            paymentRepo.deleteById(pid);
        }else {
            throw new RuntimeException("Please check the Payment ID.. No Such Payment..!");
        }
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (paymentRepo.existsById(dto.getPid())){
            paymentRepo.save(modelMapper.map(dto,Payment.class));
        }else {
            throw new RuntimeException("No Such Payment To Update..! Please Check the ID..!");
        }
    }

    @Override
    public PaymentDTO searchPayment(String pid) {
        if (paymentRepo.existsById(pid)){
            return modelMapper.map(paymentRepo.findById(pid).get(), PaymentDTO.class);
        }else {
            throw new RuntimeException("No Payment For " + pid + " ..!");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return modelMapper.map(paymentRepo.findAll(),new TypeToken<List<PaymentDTO>>(){}.getType());
    }
}
