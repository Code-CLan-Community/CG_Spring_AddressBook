package com.example.addressbook.repository;


import com.example.addressbook.model.vrAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface vrAdRepo extends JpaRepository<vrAd, Long> {
}
