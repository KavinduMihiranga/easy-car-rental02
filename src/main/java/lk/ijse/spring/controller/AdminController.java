package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAdmin() {
        return new ResponseUtil(200,"Ok",adminService.getAllAdmin());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.saveAdmin(adminDTO);
        return new ResponseUtil(200,"Save",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.updateAdmin(adminDTO);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"aid"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String aid) {
        adminService.deleteAdmin(aid);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{aid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@RequestParam String aid) {
        return new ResponseUtil(200,"Ok",adminService.searchAdmin(aid));
    }


}
