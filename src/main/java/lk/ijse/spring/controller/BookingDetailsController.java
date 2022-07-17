package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.BookingDetailsDTO;
import lk.ijse.spring.service.BookingDetailsService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bookingDetails")
@CrossOrigin
public class BookingDetailsController {

    @Autowired
    BookingDetailsService bookingDetailsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllBookingDetails() {
        return new ResponseUtil(200,"Ok",bookingDetailsService.getAllBookingDetails());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveBookingDetails(@RequestBody BookingDetailsDTO bookingDetailsDTO) {
        bookingDetailsService.saveBookingDetails(bookingDetailsDTO);
        return new ResponseUtil(200,"Save",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBookingDetails(@RequestBody BookingDetailsDTO bookingDetailsDTO) {
        bookingDetailsService.updateBookingDetails(bookingDetailsDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"bdid"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteBookingDetails(@RequestParam String bdid) {
        bookingDetailsService.deleteBookingDetails(bdid);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{bdid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchBookingDetails(@RequestParam String bdid) {
        return new ResponseUtil(200,"Ok",bookingDetailsService.searchBookingDetails(bdid));
    }


}
