package com.E_CommercePortal.Controller;

import com.E_CommercePortal.Entity.Users;
import com.E_CommercePortal.ServiceIMPL.UsersServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersServiceIMPL usersServiceIMPL;

    @PostMapping("/add")
    public ResponseEntity<Users> addUsers(@RequestBody Users users){
        Users saved = usersServiceIMPL.addUsers(users);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Users> getUser(@RequestParam int userId){
        Users user = usersServiceIMPL.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
