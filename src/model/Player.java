/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;


/**
 * Class representing players in the system.
 * 
 * @author 
 */

@Entity
@PrimaryKeyJoinColumn(name = "PLAYER_ID", foreignKey = @jakarta.persistence.ForeignKey(name = "FK_PLAYER_PERSON"))
@Table(name = "PLAYERS")
public class Player extends Person implements Serializable {

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", foreignKey = @jakarta.persistence.ForeignKey(name = "FK_PLAYER_TEAM"))
    private Team team;
    private String position; // Player's position
    private int number; // Player's number
    
    @ManyToMany
    @JoinTable(name = "PLAYER_POSITION",
            joinColumns = @JoinColumn(name = "PLAYER_ID"),
            inverseJoinColumns = @JoinColumn(name = "POSITION_ID"),
            foreignKey = @jakarta.persistence.ForeignKey(name = "FK_PLAYER_POSITION"),
            inverseForeignKey = @jakarta.persistence.ForeignKey(name = "FK_POSITION_PLAYER"))
    private Set<Position> positions = new HashSet<>();

    public Player() {
    }

    public Player(String firstName, String lastName) {
        super(firstName, lastName);
    }
    
     
    public Player(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName);
        this.setBirthDate(birthDate); // Assuming the `Person` class has a birthDate field
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getPosition() {
    return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return "Player: " + super.getFirstName() + " " + super.getLastName() +
               ", Team: " + (team != null ? team.getName() : "None") +
               ", Number of positions: " + positions.size();
    }

    }
