package com.izinmodul.entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_manager")
public class ManagerEntity {
    private int managerId;
    private EmployeeEntity Employee;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "manager_id", nullable = false, insertable = true, updatable = true)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerEntity that = (ManagerEntity) o;

        if (managerId != that.managerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return managerId;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    public EmployeeEntity getEmployee() {
        return Employee;
    }

    public void setEmployee(EmployeeEntity tblEmployeeByEmployeeId) {
        this.Employee = tblEmployeeByEmployeeId;
    }

}
