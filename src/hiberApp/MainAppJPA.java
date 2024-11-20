/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import model.Team;
import model.Player;

/**
 * Main class for testing JPA queries
 * 
 * @author 
 */

public final class MainAppJPA {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        testJPQLPlayers();
        testJPQLTeams();
        FACTORY.close();
    }

    /**
     * Displays a list of all players.
     */
    public static void testJPQLPlayers() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Player> result = em.createQuery("SELECT p FROM Player p", Player.class).getResultList();
            result.forEach(player -> {
                System.out.println("Player: " + player.getFirstName() + " " + player.getLastName()
                        + ", Position: " + player.getPosition()
                        + ", Team: " + (player.getTeam() != null ? player.getTeam().getName() : "No team"));
            });
            System.out.println("=======================");
        }
    }

    /**
     * Displays a list of all teams.
     */
    public static void testJPQLTeams() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Team> result = em.createQuery("SELECT t FROM Team t", Team.class).getResultList();
            result.forEach(team -> {
                System.out.println("Team: " + team.getName() + ", Country: " + team.getCountry());
                System.out.println("Players:");
                team.getPlayers().forEach(player -> {
                    System.out.println(" - " + player.getFirstName() + " " + player.getLastName());
                });
                System.out.println("=======================");
            });
        }
    }
}


