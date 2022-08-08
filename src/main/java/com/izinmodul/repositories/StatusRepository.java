package com.izinmodul.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izinmodul.entities.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {
}
