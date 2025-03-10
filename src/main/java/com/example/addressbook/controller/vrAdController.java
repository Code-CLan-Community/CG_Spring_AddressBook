package com.example.addressbook.controller;

import com.example.addressbook.model.vrAd;
import com.example.addressbook.service.vrAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class vrAdController {

    private final vrAdService vrAdSvc;

    @Autowired
    public vrAdController(vrAdService vrAdSvc) {
        this.vrAdSvc = vrAdSvc;
    }

    @GetMapping
    public List<vrAd> getAllAddresses() {
        return vrAdSvc.getAll();
    }

    @PostMapping
    public vrAd addAddress(@RequestBody vrAd vrAd) {
        return vrAdSvc.add(vrAd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<vrAd> getAddress(@PathVariable Long id) {
        return vrAdSvc.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<vrAd> updateAddress(@PathVariable Long id, @RequestBody vrAd vrAd) {
        vrAd updatedVrAd = vrAdSvc.update(id, vrAd);
        return (updatedVrAd != null) ? ResponseEntity.ok(updatedVrAd) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        vrAdSvc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
