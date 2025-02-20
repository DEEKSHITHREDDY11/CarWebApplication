package com.MicroService.MicroService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cars
{
    @Id
    private Integer carid;
    private String carname;
    private int price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users user;

}