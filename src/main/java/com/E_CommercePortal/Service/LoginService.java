package com.E_CommercePortal.Service;

import com.E_CommercePortal.Payload.LoginDto;
import com.E_CommercePortal.Payload.TokenDto;

public interface LoginService {
    public TokenDto login(LoginDto dto);
}
