package com.izinmodul.entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_employee")
public class EmployeeEntity {
    private int employeeId;
    private double employeeBalance;
    private String employeeName;
    private String employeeSurname;
    private int employeeWorkedYear;

    
    @Basic
    @Column(name = "employee_worked_year", nullable = false, insertable = true, updatable = true)
    public int getEmployeeWorkedYear() {
		return employeeWorkedYear;
	}

	public void setEmployeeWorkedYear(int employeeWorkedYear) {
		this.employeeWorkedYear = employeeWorkedYear;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "employee_id", nullable = false, insertable = true, updatable = true)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employee_balance", nullable = true, insertable = true, updatable = true, precision = 0)
    public double getEmployeeBalance() {
        return employeeBalance;
    }

    public void setEmployeeBalance(double employeeBalance) {
        this.employeeBalance = employeeBalance;
    }

    @Basic
    @Column(name = "employee_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Basic
    @Column(name = "employee_surname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (employeeId != that.employeeId) return false;
        if (employeeName != null ? !employeeName.equals(that.employeeName) : that.employeeName != null) return false;
        if (employeeSurname != null ? !employeeSurname.equals(that.employeeSurname) : that.employeeSurname != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (employeeSurname != null ? employeeSurname.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", employeeBalance=" + employeeBalance +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                '}';
    }
}
