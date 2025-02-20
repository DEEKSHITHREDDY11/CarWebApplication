package com.MicroService.MicroService.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String username;
    private String emailid;
    private String password;
    private String status;
    private String type;

    @OneToMany(mappedBy = "user")
    private List<Cars> cars;
}
