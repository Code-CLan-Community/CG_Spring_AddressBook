package com.example.addressbook.service.impl;

import com.example.addressbook.model.vrAd;
import com.example.addressbook.repository.vrAdRepo;
import com.example.addressbook.service.vrAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class vrAdServiceImpl implements vrAdService {

    private final vrAdRepo vrAdRepo;

    @Autowired
    public vrAdServiceImpl(vrAdRepo vrAdRepo) {
        this.vrAdRepo = vrAdRepo;
    }

    @Override
    public List<vrAd> getAll() {
        return vrAdRepo.findAll();
    }

    @Override
    public vrAd add(vrAd vrAd) {
        return vrAdRepo.save(vrAd);
    }

    @Override
    public Optional<vrAd> getById(Long id) {
        return vrAdRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        vrAdRepo.deleteById(id);
    }
}
