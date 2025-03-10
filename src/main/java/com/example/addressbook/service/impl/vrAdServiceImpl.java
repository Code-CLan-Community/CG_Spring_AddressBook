package com.example.addressbook.service.impl;

import com.example.addressbook.model.vrAd;
import com.example.addressbook.repository.vrAdRepo;
import com.example.addressbook.service.vrAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class vrAdServiceImpl implements vrAdService {

    private final vrAdRepo vrAdRepository;

    @Override
    public List<vrAd> getAll() {
        return vrAdRepository.findAll();
    }

    @Override
    public vrAd add(vrAd vrAd) {
        return vrAdRepository.save(vrAd);
    }

    @Override
    public Optional<vrAd> getById(Long id) {
        return vrAdRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        vrAdRepository.deleteById(id);
    }
}
