package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Address;
import com.E_CommercePortal.Repository.AddressRepository;
import com.E_CommercePortal.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceIMPL implements AddressService {

    @Autowired
    private AddressRepository addressrepository;

    @Override
    public Address addAddress(Address address) {
        return addressrepository.save(address);
    }
}
