package com.example.backend;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
    Optional<ServiceModel> findById(Long id);
    void deleteById(long id);
}
