package com.example.smartphoneajax.service;

import com.example.smartphoneajax.model.Smartphone;
import com.example.smartphoneajax.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return iSmartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return iSmartphoneRepository.save(smartphone);
    }

    @Override
    public void deleteSmartphone(Long id) {
        iSmartphoneRepository.deleteById(id);
    }
}
