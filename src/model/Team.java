/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Class representing teams in the system.
 * 
 * @author 
 */
@Entity
@Table(name = "TEAMS")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private int id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String country;

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new HashSet<>();

    public Team() {
    }
    
    private Set<Match> matches = new HashSet<>();
    
    public Team(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }


    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public Set<Match> getMatches() {
        return matches;
    }
    @Override
    public String toString() {
        return "Team: " + name + ", Country: " + country + ", Number of players: " + players.size();
    }
}


