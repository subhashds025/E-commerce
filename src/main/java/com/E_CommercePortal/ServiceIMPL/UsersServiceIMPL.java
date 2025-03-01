package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.User_Role;
import com.E_CommercePortal.Entity.Users;
import com.E_CommercePortal.Payload.UserDto;
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

    @Override
    public Users getUser(int userId) {
        Optional<Users> opUser = usersRepository.findById(userId);
   if(opUser.isPresent()){
       Users users = opUser.get();
       return users;
   }else{
       throw new RuntimeException("user with this id not found");
   }
    }

    @Override
    public Users updateUser(UserDto dto, int userId) {
        Optional<Users> opUser = usersRepository.findById(userId);
        if(opUser.isPresent()){
            Users users = opUser.get();
            users.setPassword(dto.getPassword());
            users.setEmail(dto.getEmail());
            users.setMobile(dto.getMobile());
            users.setFirstName(dto.getFirstName());
            users.setLastName(dto.getLastName());
            Users saved = usersRepository.save(users);
            return saved;
        }else{
            throw new RuntimeException("user not found");
        }
    }
}
