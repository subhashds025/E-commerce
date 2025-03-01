package com.E_CommercePortal.Controller;


import com.E_CommercePortal.Payload.LoginDto;
import com.E_CommercePortal.Payload.TokenDto;
import com.E_CommercePortal.Service.LoginService;
import com.E_CommercePortal.ServiceIMPL.LoginServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginServiceIMPL loginServiceIMPL;

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto dto){
        TokenDto tokenDto = loginServiceIMPL.login(dto);
        return new ResponseEntity<>(tokenDto, HttpStatus.OK);
    }
}
