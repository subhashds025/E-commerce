package com.E_CommercePortal.Repository;

import com.E_CommercePortal.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.email=:userEmail and u.mobile=:mobile")
    Optional<Users> findUserByEmailAndMobile(@Param("userEmail")String email,@Param("mobile")String mobile);

    @Query("select u from Users u where u.email=:email")
    Optional<Users> findUserByEmail(@Param("email")String email);

    @Query("select u from Users u where u.password=:password")
    Optional<Users> findUserByPassword(@Param("password")String password);
}