package com.example.addressbook.service;

import com.example.addressbook.model.vrAd;

import java.util.List;
import java.util.Optional;

public interface vrAdService {
    List<vrAd> getAll();
    vrAd add(vrAd vrAd);
    Optional<vrAd> getById(Long id);
    vrAd update(Long id, vrAd vrAd);
    void delete(Long id);
}
