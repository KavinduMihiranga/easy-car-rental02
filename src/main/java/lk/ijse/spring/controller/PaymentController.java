package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.service.PaymentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayment() {
        return new ResponseUtil(200,"Ok",paymentService.getAllPayment());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.savePayment(paymentDTO);
        return new ResponseUtil(200,"Save",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.updatePayment(paymentDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"pid"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePayment(@RequestParam String pid) {
        paymentService.deletePayment(pid);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchPayment(@RequestParam String pid) {
        return new ResponseUtil(200,"Ok",paymentService.searchPayment(pid));
    }

}
