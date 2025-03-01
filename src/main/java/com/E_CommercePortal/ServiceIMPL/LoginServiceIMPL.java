package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Users;
import com.E_CommercePortal.Payload.LoginDto;
import com.E_CommercePortal.Payload.TokenDto;
import com.E_CommercePortal.Repository.UsersRepository;
import com.E_CommercePortal.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceIMPL implements LoginService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JWTService jwtService;

    @Override
    public TokenDto login(LoginDto dto) {
        Optional<Users> opEmail = usersRepository.findUserByEmail(dto.getEmail());
        TokenDto tokenDto=new TokenDto();
        if(opEmail.isPresent()){
            Users users = opEmail.get();
           if(BCrypt.checkpw(dto.getPassword(),users.getPassword())){
               String token = jwtService.getToken(users);
               tokenDto.setType("JWT");
               tokenDto.setToken(token);
               return tokenDto;
           }
        }else {
            throw new RuntimeException("enter correct email and password");
        }
        return null;
    }
}
