/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import model.*;
import java.util.List;

/**
 * Class for querying test data
 * 
 * @author 
 */
public final class DataQueries {

 
  public void showPersons(EntityManagerFactory FACTORY) {
    try (EntityManager em = FACTORY.createEntityManager()) {
        Query query = em.createQuery("SELECT p FROM Person p");
        List<Person> persons = query.getResultList();
        persons.forEach(person -> {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        });
    }
}


    /**
     * Displays all teams.
     *
     * @param FACTORY EntityManagerFactory for creating EntityManager
     */
    public void showTeams(EntityManagerFactory FACTORY) {
        try (EntityManager em = FACTORY.createEntityManager()) {
            Query query = em.createQuery("SELECT t FROM Team t");
            List<Team> teams = query.getResultList();
            teams.forEach(team -> {
                System.out.println("Team Name: " + team.getName() + ", Country: " + team.getCountry());
            });
        }
    }

    /**
     * Displays all matches.
     *
     * @param FACTORY EntityManagerFactory for creating EntityManager
     */
    public void showMatches(EntityManagerFactory FACTORY) {
        try (EntityManager em = FACTORY.createEntityManager()) {
            Query query = em.createQuery("SELECT m FROM Match m");
            List<Match> matches = query.getResultList();
            matches.forEach(match -> {
                System.out.println("Date: " + match.getDate() + ", Result: " + match.getResult()
                        + ", Home Team: " + match.getHomeTeam().getName()
                        + ", Away Team: " + match.getAwayTeam().getName()
                        + ", Stadium: " + match.getStadium().getName());
            });
        }
    }

    /**
     * Displays all objects in the database.
     *
     * @param FACTORY EntityManagerFactory for creating EntityManager
     */
    public void showAll(EntityManagerFactory FACTORY) {
        try (EntityManager em = FACTORY.createEntityManager()) {
            Query query = em.createQuery("SELECT o FROM java.lang.Object o");
            List<Object> all = query.getResultList();
            all.forEach(System.out::println);
        }
    }
}


