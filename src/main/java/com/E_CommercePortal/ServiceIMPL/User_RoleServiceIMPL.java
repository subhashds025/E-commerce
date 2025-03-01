package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Roles;
import com.E_CommercePortal.Entity.User_Role;
import com.E_CommercePortal.Entity.Users;
import com.E_CommercePortal.Repository.RolesRepository;
import com.E_CommercePortal.Repository.User_RoleRepository;
import com.E_CommercePortal.Repository.UsersRepository;
import com.E_CommercePortal.Service.User_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class User_RoleServiceIMPL implements User_RoleService {

    @Autowired
    private User_RoleRepository userRoleRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public User_Role addUserRole(Integer userId, Integer roleId) {
        User_Role userRole=new User_Role();
        Optional<Users> opUsers = usersRepository.findById(userId);
        if(opUsers.isPresent()){
            Users users = opUsers.get();
            userRole.setUsers(users);
        }else {
            throw new RuntimeException("user not found with this id="+userId);
        }
        Optional<Roles> opRole = rolesRepository.findById(roleId);
        if(opRole.isPresent()){
            Roles roles = opRole.get();
            userRole.setRoles(roles);
        }else {
            throw new RuntimeException("role is not found with this id="+roleId);
        }
       return userRoleRepository.save(userRole);
    }

    @Override
    public User_Role getUserRole(Integer userId) {
      return   userRoleRepository.findUser_RoleByUserId(userId);
    }
}
