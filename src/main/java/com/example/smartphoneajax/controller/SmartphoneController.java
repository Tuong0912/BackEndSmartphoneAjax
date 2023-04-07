package com.example.smartphoneajax.controller;


import com.example.smartphoneajax.model.Smartphone;
import com.example.smartphoneajax.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/smartphone")
@CrossOrigin("*")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService iSmartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> getAllSmartphonePage() {
        return new ResponseEntity<>(iSmartphoneService.findAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Smartphone> deleteSmartphoneById(@PathVariable Long id) {
        Optional<Smartphone> smartphone = this.iSmartphoneService.findById(id);
        if (smartphone.isPresent()) {
            this.iSmartphoneService.deleteSmartphone(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
