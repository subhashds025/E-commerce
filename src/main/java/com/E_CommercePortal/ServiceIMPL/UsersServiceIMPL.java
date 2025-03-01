package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.User_Role;
import com.E_CommercePortal.Entity.Users;
import com.E_CommercePortal.Repository.UsersRepository;
import com.E_CommercePortal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceIMPL implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    User_Role userRole=new User_Role();
    @Override
    public Users addUsers(Users users) {
        Optional<Users> opUser = usersRepository.findUserByEmailAndMobile(users.getEmail(), users.getMobile());
        if(opUser.isPresent()){
            throw new RuntimeException("user is already registerted");
        }else{
            String newPassword=BCrypt.hashpw(users.getPassword(),BCrypt.gensalt(10));
            users.setPassword(newPassword);
            return usersRepository.save(users);
        }



    }
}
