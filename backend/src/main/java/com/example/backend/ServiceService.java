package com.example.backend;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<ServiceModel> getAll() {
        var list = repository.findAll();
        return list;
    }

    public ServiceModel getById(Long id) {
        var model = repository.findById(id).get();
        return model;
    }

    public List<ServiceModel> getPendingServices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals("PENDING"))
            .toList();
        return list;
    }

    public List<ServiceModel> getDoneServices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals("DONE"))
            .toList();
        return list;
    }

    public List<ServiceModel> getCancelledervices() {
        var list = repository
            .findAll()
            .stream()
            .filter(e -> e.getStatus().equals("CANCELLED"))
            .toList();
        return list;
    }

    public void save(ServiceModel model) {
        if (model.getStatus() == "") { 
            model.setStatus("PENDING");
        }
        repository.saveAndFlush(model);
    }

    public void cancelService(Long id) {
        var model = repository.findById(id).get();
        if (model.getStatus().equals("PENDING")) {
            model.setStatus("CANCELLED");
            repository.saveAndFlush(model);
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
