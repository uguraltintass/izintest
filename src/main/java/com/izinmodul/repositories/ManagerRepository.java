package com.izinmodul.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izinmodul.entities.EmployeeEntity;
import com.izinmodul.entities.ManagerEntity;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {

    public ManagerEntity findByEmployee(EmployeeEntity employeeEntity);
}
