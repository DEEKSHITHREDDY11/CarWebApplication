package com.MicroService.MicroService.displayers;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

@Component
public interface CarDisplay
{
    Integer getcarid();
    String getcarname();
}
