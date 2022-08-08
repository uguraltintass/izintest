package com.izinmodul.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.izinmodul.entities.EmployeeEntity;
import com.izinmodul.entities.LeaveHistoryEntity;
import com.izinmodul.entities.ManagerEntity;

import java.util.List;

@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistoryEntity, Integer> {


    List<LeaveHistoryEntity> findByManager(ManagerEntity manager);
    List<LeaveHistoryEntity> findByEmployeeAndLeaveCancelled(EmployeeEntity employee, Byte cancelled);
    List<LeaveHistoryEntity> findByLeaveCancelled(Byte cancelled);

}
