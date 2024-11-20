/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.time.LocalDate;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;
import java.util.HashSet;

/**
 * Class for loading test data into the database
 *  
 * @author
 */
public final class DataLoad {


    static Logger log = LoggerFactory.getLogger(DataLoad.class);

    protected void createData(EntityManagerFactory FACTORY) {

        try (EntityManager em = FACTORY.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();
                log.trace("Insert Person transaction begin");

                // Example persons (general)
                Person person1 = new Person("John", "Doe");
                em.persist(person1);
                Person person2 = new Person("Jane", "Doe");
                em.persist(person2);

                log.trace("Insert Person transaction commit");
                tx.commit();
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                    log.error("Transaction rollback: " + e.getMessage());
                }
            }

            tx = em.getTransaction();
            tx.begin();

            // Teams
            Team team1 = new Team("FC Barcelona", "Spain");
            Team team2 = new Team("Bayern Munich", "Germany");
            em.persist(team1);
            em.persist(team2);

            // Stadiums
            Stadium stadium1 = new Stadium("Camp Nou", "Barcelona");
            Stadium stadium2 = new Stadium("Allianz Arena", "Munich");
            em.persist(stadium1);
            em.persist(stadium2);

            // Coaches
            Coach coach1 = new Coach("Pep", "Guardiola");
            coach1.setTeam(team1); 
            Coach coach2 = new Coach("Julian", "Nagelsmann");
            coach2.setTeam(team2); 
            em.persist(coach1);
            em.persist(coach2);

            // Players
            Player player1 = new Player("Lionel", "Messi", LocalDate.parse("1987-06-24"));
            player1.setTeam(team1); 
            player1.setPosition("Striker"); 
            player1.setNumber(10);

            Player player2 = new Player("Robert", "Lewandowski", LocalDate.parse("1988-08-21"));
            player2.setTeam(team2); 
            player2.setPosition("Striker");
            player2.setNumber(9);

            Player player3 = new Player("Manuel", "Neuer", LocalDate.parse("1986-03-27"));
            player3.setTeam(team2); 
            player3.setPosition("Goalkeeper");
            player3.setNumber(1);

            em.persist(player1);
            em.persist(player2);
            em.persist(player3);

            // Matches
            Match match1 = new Match(LocalDate.parse("2023-05-10"), "3-2", team1, team2, stadium1);
            Match match2 = new Match(LocalDate.parse("2023-06-15"), "1-1", team2, team1, stadium2);
            em.persist(match1);
            em.persist(match2);

            // Adding matches to teams
            Set<Match> team1Matches = new HashSet<>();
            team1Matches.add(match1);
            team1Matches.add(match2);
            team1.setMatches(team1Matches); 

            Set<Match> team2Matches = new HashSet<>();
            team2Matches.add(match1);
            team2Matches.add(match2);
            team2.setMatches(team2Matches); 

            // Positions
            Position position1 = new Position("Goalkeeper", 90); 
            Position position2 = new Position("Striker", 90); 
            em.persist(position1);
            em.persist(position2);

            tx.commit();
            log.trace("Test data committed successfully");

        } catch (Exception e) {
            log.error("Error during data load: " + e.getMessage());
        }
    }
}


