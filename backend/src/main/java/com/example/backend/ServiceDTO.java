package com.example.backend;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;
import org.springframework.http.ResponseEntity;

@Getter
public class ServiceDTO {

    private String fullName;
    private LocalDate requestingDate;
    private BigDecimal price;
    private String description;
    private BigDecimal amountPaid;
    private BigDecimal change;
    private LocalDate paymentDate;
    private Status status;

    public ServiceDTO(ServiceModel model) {
        this.fullName = model.getFullName();
        this.requestingDate = model.getRequestingDate();
        this.price = BigDecimal.valueOf(model.getPrice()).setScale(2);
        this.description = model.getDescription();
        this.amountPaid = BigDecimal.valueOf(model.getAmountPaid()).setScale(2);
        this.change = BigDecimal.valueOf(model.getChange()).setScale(2);
        this.paymentDate = model.getPaymentDate();
        this.status = model.getStatus();
    }

    public static ResponseEntity<ServiceDTO> createInstance(ServiceModel model) {
        return ResponseEntity.ok(new ServiceDTO(model));
    }
    
    public static ResponseEntity<List<ServiceDTO>> dtoMapper(List<ServiceModel> models) {
        var list = models.stream().map(ServiceDTO::new).toList();
        return ResponseEntity.ok(list);
    }

}
