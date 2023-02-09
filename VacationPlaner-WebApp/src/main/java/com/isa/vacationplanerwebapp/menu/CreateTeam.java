package com.isa.vacationplanerwebapp.menu;



import com.isa.vacationplanerwebapp.dataManager.DataManager;
import com.isa.vacationplanerwebapp.model.Team;

import java.util.Scanner;

public class CreateTeam {
    public void create() {
        while (true) {
            Team team = new Team("jako");

            team.setTeamName(dataInput("Podaj nazwe zespołu"));

            DataManager.addTeam(team);

            String response = dataInput("Dodać kolejny zespół? (y/n)");
            System.out.println(response);
            if (response.equals("n")) {
                break;
            }
        }
    }
    public String dataInput(String question) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println(question);
        input = scanner.nextLine();
        return input;
    }
}
