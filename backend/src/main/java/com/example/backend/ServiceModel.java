package com.example.backend;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    private Double price;
    private String description;
    private Double amountPaid;
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    private String status;

}