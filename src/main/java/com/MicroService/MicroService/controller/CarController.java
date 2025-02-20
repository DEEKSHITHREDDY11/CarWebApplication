package com.MicroService.MicroService.controller;


import com.MicroService.MicroService.model.Cars;
import com.MicroService.MicroService.model.Users;
import com.MicroService.MicroService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController
{
    @Autowired
    private CarService service;

    @GetMapping("/") // Cars home page link
    public List<?> display()
    {
        return service.display();
    }

    @GetMapping("/details/{id}") // Car details by ID link
    public List<?> details(@PathVariable int id)
    {
        return service.details(id);
    }

    @PostMapping("/new") // creation of new car link
    public void newCar(@RequestBody Cars cars)
    {
        service.newCar(cars);
    }

    @GetMapping("/carCart/{userid}") // To get total price and car details link
    public Object carCart(@PathVariable int userid)
    {
        return service.getRevenue(userid);
    }

    @PutMapping("/addCart/{userid}")  // Add cars into cart link
    public void addCart(@PathVariable int userid,@RequestBody Cars cars)
    {
        service.addCart(userid,cars.getCarid());
    }
}
