package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SearchForEmployee {
    Scanner scanner = new Scanner(System.in);

    public void search() {
        System.out.println("ZA POMOCĄ CZEGO CHCZESZ WYSZUKAĆ? \n 1-IMIĘ \n 2-NAZWISKO \n 3-PESEL \n 4-WSZYSTKO");
        try {
            insideSearchingMenu();
        } catch (InputMismatchException ex){
            System.out.println("PODAJ CYFRE");
        } catch (RuntimeException exc) {
            System.out.println("PODAJ CYFRE Z OKREŚLONEGO PRZEDZIAŁU");
        } catch (Exception e) {
            System.out.println("BŁĄD");
        }

    }

    private void insideSearchingMenu() {
        int value = scanner.nextInt();
        switch (value) {
            case 1 -> searchByName();
            case 2 -> searchBySurname();
            case 3 -> searchByPesel();
            case 4 -> searchByAnything();
        }
    }

    private void searchByName() {
        String searchTerm = getSearchTerm();
        boolean found = false;
        for (Employee employee : DataManager.employeeList) {
            if (employee.getName().toLowerCase().startsWith(searchTerm.toLowerCase())) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!(found)) {
            System.out.println("NIESTETY, NIE MA PRACOWNIKA KTÓRY ODPOWIADA TWOJEMU WYSZUKIWANIU");

        }

    }

    private void searchBySurname() {
        String searchTerm = getSearchTerm();
        boolean found = false;
        for (Employee employee : DataManager.employeeList) {
            if (employee.getSurname().toLowerCase().startsWith(searchTerm.toLowerCase())) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!(found)) {
            System.out.println("NIESTETY, NIE MA PRACOWNIKA KTÓRY ODPOWIADA TWOJEMU WYSZUKIWANIU");
        }
    }

    private void searchByPesel() {
        String searchTerm = getSearchTerm();
        boolean found = false;
        for (Employee employee : DataManager.employeeList) {
            if (employee.getPesel().toLowerCase().startsWith(searchTerm.toLowerCase())) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!(found)) {
            System.out.println("NIESTETY, NIE MA PRACOWNIKA KTÓRY ODPOWIADA TWOJEMU WYSZUKIWANIU");
        }

    }

    private void searchByAnything() {
        String searchTerm = getSearchTerm();
        boolean found = false;
        for (Employee employee : DataManager.employeeList) {
            if (isMatch(employee, searchTerm)) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!(found)) {
            System.out.println("NIESTETY, NIE MA PRACOWNIKA KTÓRY ODPOWIADA TWOJEMU WYSZUKIWANIU");
        }

    }
    private boolean isMatch(Employee employee, String searchTerm) {
        List<String> fields = Arrays.asList(
                employee.getName().toLowerCase(),
                employee.getSurname().toLowerCase(),
                employee.getPesel().toLowerCase(),
                employee.getPhoneNumber().toLowerCase(),
                employee.getAddress().toLowerCase(),
                employee.getTeam().toLowerCase(),
                employee.getEmail().toLowerCase()
        );

        return fields.stream().anyMatch(field -> field.startsWith(searchTerm.toLowerCase()));
    }

    private String getSearchTerm() {
        System.out.println("WPISZ FRAZE ZA POMOCĄ KTÓREJ CHCESZ WYSZUKAĆ:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
