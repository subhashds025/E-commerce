package com.E_CommercePortal.Service;

import com.E_CommercePortal.Entity.Users;
import com.E_CommercePortal.Payload.UserDto;

public interface UserService {
    public Users addUsers(Users users);
    public Users getUser(int userId);
    public Users updateUser(UserDto dto,int userId);
}
