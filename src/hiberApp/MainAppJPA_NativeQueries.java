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
import model.Stadium;

/**
 * Main class for testing native queries (Native Queries)
 * 
 * @author 
 */

public final class MainAppJPA_NativeQueries {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        MainAppJPA_NativeQueries test = new MainAppJPA_NativeQueries();
        test.testNativeQueryPlayers();
        test.testNativeQueryTeams();
        test.testNativeQueryStadiums();
        FACTORY.close();
    }

    /**
     * Tests the native query for players.
     */
    private void testNativeQueryPlayers() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Player> result = em
                    .createNativeQuery(
                            "SELECT p.PER_ID, p.first_name, p.last_name, p.position, p.team_id " +
                            "FROM players p", 
                            Player.class)
                    .getResultList();
            result.forEach(player -> {
                System.out.println("Player: " + player.getFirstName() + " " + player.getLastName()
                        + ", Position: " + player.getPosition()
                        + ", Team ID: " + (player.getTeam() != null ? player.getTeam().getId() : "None"));
            });
            System.out.println("=======================");
        }
    }

    /**
     * Tests the native query for teams.
     */
    private void testNativeQueryTeams() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Team> result = em
                    .createNativeQuery(
                            "SELECT t.TEAM_ID, t.name, t.country " +
                            "FROM teams t", 
                            Team.class)
                    .getResultList();
            result.forEach(team -> {
                System.out.println("Team: " + team.getName() + ", Country: " + team.getCountry());
            });
            System.out.println("=======================");
        }
    }

    /**
     * Tests the native query for stadiums.
     */
    private void testNativeQueryStadiums() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Stadium> result = em
                    .createNativeQuery(
                            "SELECT s.STADIUM_ID, s.name, s.location " +
                            "FROM stadiums s", 
                            Stadium.class)
                    .getResultList();
            result.forEach(stadium -> {
                System.out.println("Stadium: " + stadium.getName() + ", Location: " + stadium.getLocation());
            });
            System.out.println("=======================");
        }
    }
}






