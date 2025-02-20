package com.MicroService.MicroService.service;


import com.MicroService.MicroService.model.Users;
import com.MicroService.MicroService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepo repo;


    public String login(String emailid, String password)
    {
        boolean isvalid = check(emailid, password);
        if(isvalid)
        {
            return "Login Successful!......" ;
        }
        else
        {
            throw new RuntimeException("Failed Login!...");
        }
    }

    public Boolean check(String emailid, String password)
    {
        return (repo.findAllByEmailidAndPassword(emailid,password).isPresent());
    }


    public List<?> details(int id)
    {
        return repo.findAllByUserid(id);
    }


    public void newUser(Users user)
    {
        repo.save(user);
    }

    public String status(int userid)
    {
        return repo.getStatus(userid);
    }

    public String type(int userid)
    {
        return repo.getType(userid);
    }
}
