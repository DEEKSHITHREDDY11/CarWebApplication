package com.MicroService.MicroService.controller;


import com.MicroService.MicroService.model.Cars;
import com.MicroService.MicroService.model.Users;
import com.MicroService.MicroService.service.CarService;
import com.MicroService.MicroService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private UserService service;
    private CarService carService;

    @Autowired
    public UserController(UserService service , CarService carService)
    {
        this.service = service;
        this.carService  = carService;
    }

    @PostMapping("/login")  // Login link
    public String login(@RequestBody Users user)
    {
        return service.login(user.getEmailid(), user.getPassword());
    }

    @GetMapping("/details/{id}") // details of logged-in user link
    public List<?> details(@PathVariable int id)
    {
        return service.details(id);
    }

    @PutMapping("/admin/{carid}") // admin privilege to edit car price details link
    public void change(@PathVariable int carid,@RequestBody Cars car)
    {
        carService.price(carid, car.getPrice());
    }

    @GetMapping("/admin/userCarMap") // admin privilege to get UserCarMap link
    public List<?> userCarMap ()
    {
        return carService.userCarMap();
    }

    @PutMapping("/admin/modify")    // admin privilege to modify car details link
    public void modify(@RequestBody Cars cars)
    {
        carService.modify(cars);
    }

    @PostMapping("/new")    // Creation of new user link
    public void newUser(@RequestBody Users user)
    {
        service.newUser(user);
    }

    @GetMapping("/type/{userid}") // If type = User  link
    public Object type(@PathVariable int userid)
    {
        String type = service.type(userid);
        String status = service.status(userid);
        if(type.equals("ROLE_USER"))
        {
            if (status.equals("Rented")) // If Status = "Rented" will display the details of the car
            {
                return carService.getDetails(userid);
            }
            else  // If Status = "Not-Rented" will redirect the user to cars home such that he can see all the cars
            {
                return new RedirectView("/cars/");
            }
        }
        return Collections.singletonList("Not An User!..........");
    }



}
