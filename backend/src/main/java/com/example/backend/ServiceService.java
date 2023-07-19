package com.example.backend;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<ServiceModel>> getAll() {
        var list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<ServiceModel> getById(Long id) {
        var model = repository.findById(id).get();
        return ResponseEntity.ok(model);
    }

    public ResponseEntity<List<ServiceModel>> getPendingServices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals("PENDING"))
            .toList();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<List<ServiceModel>> getDoneServices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals("DONE"))
            .toList();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<List<ServiceModel>> getCancelledervices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals("CANCELLED"))
            .toList();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<Void> save(ServiceModel model) {
        if (model.getStatus() == "") {
            model.setStatus("PENDING");
        }
        repository.saveAndFlush(model);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> cancelService(ServiceModel model) {
        repository.saveAndFlush(model);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteById(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
}
