package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.Roles;
import com.E_CommercePortal.ServiceIMPL.RolesServiceIMPL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {


    private RolesServiceIMPL rolesServiceIMPL;

    public RolesController(RolesServiceIMPL rolesServiceIMPL) {
        this.rolesServiceIMPL = rolesServiceIMPL;
    }

    @PostMapping("/add")
    public ResponseEntity<Roles> addRoles(@RequestBody Roles roles){
        Roles saved = rolesServiceIMPL.addRoles(roles);
        return  new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
