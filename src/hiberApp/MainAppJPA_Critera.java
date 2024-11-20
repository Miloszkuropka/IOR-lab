/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Team;
import model.Match;
import metaM.Team_;
import metaM.Match_;
import metaM.Stadium_;



/**
 * Main class for testing Criteria API queries
 * 
 * @author 
 */
public final class MainAppJPA_Critera {private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        MainAppJPA_Critera test = new MainAppJPA_Critera();
        test.testCriteriaTeams();
        test.testCriteriaMatches();
        FACTORY.close();
    }

    /**
     * Tests Criteria API queries for teams.
     */
    private void testCriteriaTeams() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Team> teamQuery = cb.createQuery(Team.class);
            Root<Team> root = teamQuery.from(Team.class);
            teamQuery.select(root);

            List<Team> result = em.createQuery(teamQuery).getResultList();
            result.forEach(team -> {
                System.out.println("Team: " + team.getName() + ", Country: " + team.getCountry());
                System.out.println("Players:");
                team.getPlayers().forEach(player -> {
                    System.out.println(" - " + player.getFirstName() + " " + player.getLastName());
                });
            });
            System.out.println("=======================");
        }
    }

    /**
     * Tests Criteria API queries for matches.
     */
    private void testCriteriaMatches() {
        try (EntityManager em = FACTORY.createEntityManager()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tuple> matchQuery = cb.createTupleQuery();
            Root<Match> root = matchQuery.from(Match.class);

            matchQuery.multiselect(
                root.get(Match_.DATE),
                root.get(Match_.RESULT),
                root.get(Match_.HOME_TEAM).get(Team_.NAME),
                root.get(Match_.AWAY_TEAM).get(Team_.NAME),
                root.get(Match_.STADIUM).get(Stadium_.NAME)
            );

            List<Tuple> result = em.createQuery(matchQuery).getResultList();
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
}




