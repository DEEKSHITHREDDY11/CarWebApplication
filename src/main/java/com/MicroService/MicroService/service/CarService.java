package com.MicroService.MicroService.service;


import com.MicroService.MicroService.model.Cars;
import com.MicroService.MicroService.repo.CarRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{
    @Autowired
    private CarRepo repo;

    public List<?> display()
    {
        return repo.findAllBy();
    }

    public List<?> details(int id)
    {
        return repo.findAllByCarid (id);
    }

    @Transactional
    public void price(int carid,int price)
    {
        repo.updateCarPrice(carid,price);
    }

    public List<?> userCarMap()
    {
        return repo.findCarAndUserDetails();
    }

    public void modify(Cars cars)
    {
        repo.save(cars);
    }

    public void newCar(Cars cars)
    {
        repo.save(cars);
    }

    public List<?> getDetails(int userid)
    {
        return repo.findRentalDetails(userid);
    }

    public Object getRevenue(int userid)
    {
        return repo.getRevenue(userid);
    }


    @Transactional
    public void addCart(int userid, Integer carid)
    {
        repo.getCart(userid,carid);
    }
}
