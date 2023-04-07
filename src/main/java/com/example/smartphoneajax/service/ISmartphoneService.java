package com.example.smartphoneajax.service;

import com.example.smartphoneajax.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();
    Optional<Smartphone> findById(Long id);
    Smartphone save(Smartphone smartphone);
    void deleteSmartphone(Long id);
}
