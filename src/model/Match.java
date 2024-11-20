/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * Class representing matches in the system.
 * 
 * @author LabHiber
 */
@Entity
@Table(name = "MATCHES")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATCH_ID")
    private int id;

    @Column(name = "MATCH_DATE", nullable = false)
    private LocalDate date;

    @Column(length = 10, nullable = false)
    private String result;

    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_ID", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_MATCH_HOME_TEAM"))
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "AWAY_TEAM_ID", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_MATCH_AWAY_TEAM"))
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "STADIUM_ID", nullable = false, foreignKey = @jakarta.persistence.ForeignKey(name = "FK_MATCH_STADIUM"))
    private Stadium stadium;

    public Match() {
    }

    public Match(LocalDate date, String result, Team homeTeam, Team awayTeam, Stadium stadium) {
        this.date = date;
        this.result = result;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return "Match: " + homeTeam.getName() + " vs " + awayTeam.getName() +
               ", Date: " + date + ", Result: " + result +
               ", Stadium: " + stadium.getName();
    }
}

