package com.example.addressbook.controller;

import com.example.addressbook.model.vrAd;
import com.example.addressbook.service.vrAdService; // Import the service interface
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class vrAdController {

    private final vrAdService vrAdSvc; // Corrected service declaration

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        vrAdSvc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
