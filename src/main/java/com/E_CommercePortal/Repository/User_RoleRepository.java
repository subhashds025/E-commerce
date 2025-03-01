package com.E_CommercePortal.Repository;

import com.E_CommercePortal.Entity.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface User_RoleRepository extends JpaRepository<User_Role, Integer> {

    @Query("select ur from User_Role ur where ur.users.id=:userId")
    User_Role findUser_RoleByUserId(@Param("userId")Integer userId);
}