package lk.ijse.spring.service;

import lk.ijse.spring.dto.BookingDetailsDTO;
import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface BookingDetailsService {
    void saveBookingDetails(BookingDetailsDTO dto);
    void deleteBookingDetails(String bdid);
    void updateBookingDetails(BookingDetailsDTO dto);
    BookingDetailsDTO searchBookingDetails(String bdid);
    List<BookingDetailsDTO> getAllBookingDetails();
}
