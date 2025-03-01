package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.User_Role;
import com.E_CommercePortal.ServiceIMPL.User_RoleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userrole")
public class UserRoleController {

    @Autowired
    private User_RoleServiceIMPL userRoleServiceIMPL;

    @PostMapping("/add")
    public ResponseEntity<User_Role> addUserRole(@RequestParam Integer userId,@RequestParam Integer roleId){
        User_Role userRole = userRoleServiceIMPL.addUserRole(roleId, userId);
        return new ResponseEntity<>(userRole, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<User_Role> getUserRole(@RequestParam Integer userId){
        User_Role userRole = userRoleServiceIMPL.getUserRole(userId);
        return new ResponseEntity<>(userRole,HttpStatus.OK);
    }

}
