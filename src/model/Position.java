/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Class representing a player's position in the system.
 * 
 * @author 
 */
@Entity
@PrimaryKeyJoinColumn(name = "POS_ID", foreignKey = @jakarta.persistence.ForeignKey(name = "FK_POS_PLAYER"))
@Table(name = "POSITIONS")
public class Position extends Player {

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "TIME_PLAYED", nullable = false)
    //private int timePlayed;
    private int time; // Time on field  
    public Position() {
    }

    public Position(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "Position: " + name + ", Time on field: " + time + " minutes";
    }
}