package com.isa.vacationplanerwebapp.model;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;


public class Team {
    @NotBlankgit

    private String teamName;

    public Team() {
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }

    @Override
    public String toString() {
        return teamName;
    }
}
