package com.MicroService.MicroService.displayers;


import org.springframework.stereotype.Component;

@Component
public interface CarMap
{
    Integer getUserid();
    Integer getCarid();
    String getCarname();
    String getUsername();
}
