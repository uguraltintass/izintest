package com.izinmodul.service;

import com.izinmodul.entities.StatusEntity;
import com.izinmodul.repositories.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;


    public StatusEntity getStatus(Integer id){
      return statusRepository.findOne(id);
    }

    public String addStatus(StatusEntity statusEntity){
        statusRepository.save(statusEntity);

        return "ok";
    }
}
