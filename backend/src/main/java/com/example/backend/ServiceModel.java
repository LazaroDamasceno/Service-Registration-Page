package com.example.backend;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicos")
@Getter
@Setter
public class ServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private LocalDate requestingDate;
    private Double price;
    private String description;
    private Double amountPaid;
    private Double change;
    private LocalDate paymentDate;
    private String status;

}
