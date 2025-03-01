package com.E_CommercePortal.ServiceIMPL;

import com.E_CommercePortal.Entity.Roles;
import com.E_CommercePortal.Repository.RolesRepository;
import com.E_CommercePortal.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceIMPL implements RolesService {


    private RolesRepository rolesrepository;

    public RolesServiceIMPL(RolesRepository rolesrepository) {
        this.rolesrepository = rolesrepository;
    }

    @Override
    public Roles addRoles(Roles roles) {
        return rolesrepository.save(roles);
    }
}
