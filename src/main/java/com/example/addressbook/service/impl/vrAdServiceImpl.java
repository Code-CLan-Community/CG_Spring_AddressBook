package com.example.addressbook.service.impl;

import com.example.addressbook.model.vrAd;
import com.example.addressbook.service.vrAdService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class vrAdServiceImpl implements vrAdService {

    private final List<vrAd> vrAdList = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<vrAd> getAll() {
        return new ArrayList<>(vrAdList);
    }

    @Override
    public vrAd add(vrAd vrAd) {
        vrAd.setId(idCounter++);  // Assign unique ID
        vrAdList.add(vrAd);
        return vrAd;
    }

    @Override
    public Optional<vrAd> getById(Long id) {
        return vrAdList.stream().filter(vrAd -> vrAd.getId().equals(id)).findFirst();
    }

    @Override
    public vrAd update(Long id, vrAd updatedVrAd) {
        Optional<vrAd> existingVrAd = getById(id);
        if (existingVrAd.isPresent()) {
            vrAd vrAd = existingVrAd.get();
            vrAd.setName(updatedVrAd.getName());
            vrAd.setAddress(updatedVrAd.getAddress());
            vrAd.setPhone(updatedVrAd.getPhone());
            return vrAd;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        vrAdList.removeIf(vrAd -> vrAd.getId().equals(id));
    }
}
