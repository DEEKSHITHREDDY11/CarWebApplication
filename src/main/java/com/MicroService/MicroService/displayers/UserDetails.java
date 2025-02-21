package com.MicroService.MicroService.displayers;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface UserDetails
{
    Integer getuserid();
    String getusername();
    String getemailid();
    String getstatus();
}
