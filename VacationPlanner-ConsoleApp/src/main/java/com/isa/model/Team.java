package com.isa.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Team {
    private String teamName;

    private ArrayList<Integer> employeesID = new ArrayList<>();

    public void consoleTeamData() {
        Team team = new Team();
        team.setTeamName(teamName);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę zespołu");
        teamName = scanner.nextLine();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addEmployeesID(Integer employeesID) {
        this.employeesID.add(employeesID);
    }
    public void deleteEmployeesID(Integer employeesID) {
        this.employeesID.remove(employeesID);
    }

    public ArrayList<Integer> getEmployeesID() {
        return employeesID;
    }

    public void addEmployees(Employee employee) {
        this.employeesID.add(employee.getEmployeeId());
    }

    @Override
    public String toString() {
        return teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName) && Objects.equals(employeesID, team.employeesID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, employeesID);
    }
}
