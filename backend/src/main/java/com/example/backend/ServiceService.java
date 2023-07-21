package com.example.backend;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<ServiceDTO>> getAll() {
        return ServiceDTO.dtoMapper(repository.findAll());
    }

    public ResponseEntity<ServiceDTO> getById(Long id) {
        return ServiceDTO.createInstance(repository.findById(id).get());
    }

    public ResponseEntity<List<ServiceDTO>> getPendingServices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals(Status.PENDING))
            .toList();
        return ServiceDTO.dtoMapper(list);
    }

    public ResponseEntity<List<ServiceDTO>> getDoneServices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals(Status.DONE))
            .toList();
        return ServiceDTO.dtoMapper(list);
    }

    public ResponseEntity<List<ServiceDTO>> getCancelledervices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals(Status.CANCELLED))
            .toList();
        return ServiceDTO.dtoMapper(list);
    }

    public ResponseEntity<Void> save(ServiceModel model) {
        double charge;
        if (model.getStatus() == null) { 
            model.setStatus(Status.PENDING);
            model.setRequestingDate(LocalDate.now());
        }
        if (model.getPrice() <= model.getAmountPaid()) {
            model.setStatus(Status.DONE);
            model.setPaymentDate(LocalDate.now());
            charge = model.getAmountPaid() - model.getPrice();
            model.setChange(charge);
        }
        repository.saveAndFlush(model);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> cancelService(Long id) {
        var model = repository.findById(id).get();
        if (model.getStatus().equals(Status.PENDING)) {
            model.setStatus(Status.CANCELLED);
            repository.saveAndFlush(model);
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
