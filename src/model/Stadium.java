/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class representing a stadium in the system.
 * 
 * @author 
 */
@Entity
@Table(name = "STADIUMS")
public class Stadium implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STADIUM_ID")
    private int id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "LOCATION", length = 100, nullable = false)
    private String location;

    public Stadium() {
    }

    public Stadium(String name, String location) {
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Stadium: " + name + ", Location: " + location;
    }
}

