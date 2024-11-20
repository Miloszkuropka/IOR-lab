/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import java.util.List;
import model.Player;
import model.Position;



/**
 * Main class for testing Criteria API queries
 * 
 * @author 
 */

public final class MainAppJPA_JPQLQueries {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        MainAppJPA_JPQLQueries test = new MainAppJPA_JPQLQueries();
        test.testJPQLPlayers();
        test.testJPQLTeams();
        test.testJPQLMatches();
        test.testJPQLPositions();
        FACTORY.close();
    }

    /**
     * Displays the list of all players along with their positions.
     */
    private void testJPQLPlayers() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Player> result = em
                    .createQuery("SELECT p FROM Player p", Player.class)
                    .getResultList();
            result.forEach(player -> {
                System.out.println("Player: " + player.getFirstName() + " " + player.getLastName()
                        + ", Position: " + player.getPosition()
                        + ", Team: " + (player.getTeam() != null ? player.getTeam().getName() : "No team"));
            });
            System.out.println("=======================");
        }
    }

    /**
     * Displays the list of teams with the number of players.
     */
    private void testJPQLTeams() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Tuple> result = em
                    .createQuery("SELECT t.name, t.country, COUNT(p) " +
                                 "FROM Team t LEFT JOIN t.players p " +
                                 "GROUP BY t.name, t.country", Tuple.class)
                    .getResultList();
            result.forEach(team -> {
                System.out.println("Team: " + team.get(0) 
                        + ", Country: " + team.get(1) 
                        + ", Number of players: " + team.get(2));
            });
            System.out.println("=======================");
        }
    }

    /**
     * Displays the list of matches with their details.
     */
    private void testJPQLMatches() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Tuple> result = em
                    .createQuery("SELECT m.date, m.result, homeTeam.name, awayTeam.name, stadium.name " +
                                 "FROM Match m " +
                                 "JOIN m.homeTeam homeTeam " +
                                 "JOIN m.awayTeam awayTeam " +
                                 "JOIN m.stadium stadium", Tuple.class)
                    .getResultList();
            result.forEach(match -> {
                System.out.println("Date: " + match.get(0)
                        + ", Result: " + match.get(1)
                        + ", Home Team: " + match.get(2)
                        + ", Away Team: " + match.get(3)
                        + ", Stadium: " + match.get(4));
            });
            System.out.println("=======================");
        }
    }

    /**
     * Displays the list of positions along with the time on the field.
     */
    private void testJPQLPositions() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            List<Position> result = em
                    .createQuery("SELECT p FROM Position p", Position.class)
                    .getResultList();
            result.forEach(position -> {
                System.out.println("Position: " + position.getName() + ", Time on field: " + position.getTime());
            });
            System.out.println("=======================");
        }
    }
}






