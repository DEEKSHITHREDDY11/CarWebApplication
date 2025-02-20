package com.MicroService.MicroService.displayers;


import org.springframework.stereotype.Component;

@Component
public interface UserDetails
{
    Integer getuserid();
    String getusername();
    String getemailid();
    String getstatus();
}
