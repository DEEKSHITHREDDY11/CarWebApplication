package com.MicroService.MicroService.displayers;


import org.springframework.stereotype.Component;

@Component
public interface CarDetails
{
    Integer getcarid();
    String getcarname();
    String getstatus();
    int getprice();
}
