/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Class representing a coach in the system.
 * 
 * @author
 */
@Entity
@Table(name = "COACHES")
public class Coach extends Person implements Serializable {

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", foreignKey = @jakarta.persistence.ForeignKey(name = "FK_COACH_TEAM"))
    private Team team;

    public Coach() {
    }

    public Coach(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Coach(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Coach: " + super.getFirstName() + " " + super.getLastName() +
               ", Team: " + (team != null ? team.getName() : "None");
    }
} 


