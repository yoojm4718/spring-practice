package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.services.VehicleService;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Vehicle {
    private String name;
    private final VehicleService vehicleService;

    @Autowired
    public Vehicle(VehicleService vehicleService) {
        System.out.println("Vehicle instantiated");
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    public void initialize() {
        this.name = "Torres";
    }
}
