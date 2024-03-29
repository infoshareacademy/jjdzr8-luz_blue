package com.isa.vacationplanerwebapp.menu;


import com.isa.vacationplanerwebapp.dataManager.DataManager;
import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Team;

import java.util.Scanner;

public class PrintVacationForTeam {
    public void print() {

        while (true) {

            System.out.println("Wybierz Team, której frużyny wyświetlić urlopy:");
            printTeamNames();

            Scanner scanner = new Scanner(System.in);
            Integer integer = scanner.nextInt() - 1;
            if (integer == -1) {
                break;
            }
            String selectedTeam = DataManager.teamList.get(integer).getTeamName();
            printEmployeeFromTeam(selectedTeam);
        }
    }

    private void printEmployeeFromTeam(String team) {
        for (Employee employee : DataManager.employeeList) {
            if (employee.getTeam().equals(team)) {
                System.out.println(employee.getSurname());
            }
        }
    }

    private void printTeamNames() {
        int i = 1;
        for (Team team : DataManager.teamList) {
            System.out.println(i++ + ". " + team);
        }
        System.out.println("0. Wyjście");
    }
}


