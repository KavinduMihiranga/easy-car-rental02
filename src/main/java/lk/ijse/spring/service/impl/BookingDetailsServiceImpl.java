package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.BookingDetailsDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.BookingDetails;
import lk.ijse.spring.repo.BookingDetailsRepo;
import lk.ijse.spring.service.BookingDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingDetailsServiceImpl implements BookingDetailsService {

    @Autowired
    BookingDetailsRepo bookingDetailsRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBookingDetails(BookingDetailsDTO dto) {
        if (!bookingDetailsRepo.existsById(dto.getBdid())){
            bookingDetailsRepo.save(modelMapper.map(dto, BookingDetails.class));
        }else {
            throw new RuntimeException("bookingDetails Already Exist..!");
        }
    }

    @Override
    public void deleteBookingDetails(String bdid) {
        if (bookingDetailsRepo.existsById(bdid)){
            bookingDetailsRepo.deleteById(bdid);
        }else {
            throw new RuntimeException("Please check the bookingDetails ID.. No Such bookingDetails..!");
        }
    }

    @Override
    public void updateBookingDetails(BookingDetailsDTO dto) {
        if (bookingDetailsRepo.existsById(dto.getBdid())){
            bookingDetailsRepo.save(modelMapper.map(dto,BookingDetails.class));
        }else {
            throw new RuntimeException("No Such BookingDetails To Update..! Please Check the ID..!");
        }
    }

    @Override
    public BookingDetailsDTO searchBookingDetails(String bdid) {
        if (bookingDetailsRepo.existsById(bdid)){
            return modelMapper.map(bookingDetailsRepo.findById(bdid).get(), BookingDetailsDTO.class);
        }else {
            throw new RuntimeException("No BookingDetails For " + bdid + " ..!");
        }
    }

    @Override
    public List<BookingDetailsDTO> getAllBookingDetails() {
        return modelMapper.map(bookingDetailsRepo.findAll(),new TypeToken<List<BookingDetailsDTO>>(){}.getType());
    }
}
