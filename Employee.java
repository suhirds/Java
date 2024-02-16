package com.vehicle;

public class Employee {
    private int empId;
    private String empName;
    private String grade;

    public Employee(int empId, String empName, String grade) {
        this.empId = empId;
        this.empName = empName;
        this.grade = grade;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
