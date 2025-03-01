package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.Address;
import com.E_CommercePortal.Service.AddressService;
import com.E_CommercePortal.ServiceIMPL.AddressServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressServiceIMPL addressimpl;

    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody
    Address address){
        Address saved = addressimpl.addAddress(address);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
