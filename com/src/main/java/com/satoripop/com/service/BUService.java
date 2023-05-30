package com.satoripop.com.service;

import com.satoripop.com.model.BU;
import com.satoripop.com.repository.BURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BUService {

    @Autowired
    private BURepository buRepository;

    public List<BU> getbus() {
        List<BU> bus = new ArrayList<>();
        buRepository.findAll().forEach(
                bu -> {
                    bus.add(bu);
                }

        );
        return bus;
    }

    public void addbu(BU bu){
        buRepository.save(bu);
    }
    public void update(BU bu, long id){
        buRepository.save(bu);
    }

    public BU getbuById(long id){
        return buRepository.findById(id).orElse(null);
    }

    public void deletebu(long id) {
        buRepository.deleteById(id);
    }
}
