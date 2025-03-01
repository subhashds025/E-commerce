package com.E_CommercePortal.Service;

import com.E_CommercePortal.Entity.User_Role;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface User_RoleService {
    public User_Role addUserRole(Integer userId,Integer roleId);
    public User_Role getUserRole(Integer userId);
}
