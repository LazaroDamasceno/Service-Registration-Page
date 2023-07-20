package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
@CrossOrigin("http://localhost:5173/")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceModel> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public ServiceModel getById(@PathVariable(value = "id") Long id) {
        return service.getById(id);
    }

    @GetMapping("/pending")
    public List<ServiceModel> getPendingServices() {
        return service.getPendingServices();
    }

    @GetMapping("/done")
    public List<ServiceModel> getDoneServices() {
        return service.getDoneServices();
    }

    @GetMapping("/cancelled")
    public List<ServiceModel> getCancelledervices() {
        return service.getCancelledervices();
    }

    @PostMapping
    public void add(@RequestBody ServiceModel model) {
        service.save(model);
    }

    @PutMapping
    public void update(@RequestBody ServiceModel model) {
        service.save(model);
    }

    @PutMapping("/cancel/{id}")
    public void cancelService(@PathVariable(value = "id") Long id) {
        service.cancelService(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        service.deleteById(id);
    }

    
}
