package com.isa.model;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String pesel;
    private String email;
    private String address;
    private String phoneNumber;
    private Integer eployeeId;



    private ArrayList<Integer> vacationId;

    private ArrayList<Holiday> holidays = new ArrayList<Holiday>();
    private Team team;

    public Employee(String name, String surname, String pesel, String email, String address, String phoneNumber, ArrayList<Holiday> holidays, Team team) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.holidays = holidays;
        this.team = team;
    }

    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    public void removeHoliday(Holiday holiday) {
        holidays.remove(holiday);
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", secondName='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Employee(String name, String surname, String pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }
    public Employee(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId.add(vacationId);
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setEployeeId(Integer eployeeId) {
        this.eployeeId = eployeeId;
    }

    public Integer getEployeeId() {
        return eployeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(pesel, employee.pesel) && Objects.equals(email, employee.email) && Objects.equals(address, employee.address) && Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, pesel, email, address, phoneNumber);
    }
}


