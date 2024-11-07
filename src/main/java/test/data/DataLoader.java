/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.data;

/**
 *
 * @author student
 */
import database.Coach;
import database.Player;
import database.Position;
import database.Stadium;
import database.Team;
import database.Match;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;

public class DataLoader {

    public static void loadTestData(Session session) {
        Transaction transaction = session.beginTransaction();
        
        try {
            // Create Stadiums
            Stadium stadium1 = new Stadium();
            stadium1.setName("National Stadium");
            stadium1.setLocation("City A");

            Stadium stadium2 = new Stadium();
            stadium2.setName("City Arena");
            stadium2.setLocation("City B");

            session.save(stadium1);
            session.save(stadium2);

            // Create Teams
            Team team1 = new Team();
            team1.setCountry("Country A");

            Team team2 = new Team();
            team2.setCountry("Country B");

            session.save(team1);
            session.save(team2);

            // Create Coaches
            Coach coach1 = new Coach();
            coach1.setFName("John");
            coach1.setSName("Smith");
            coach1.setTeam(team1);
            team1.setCoach(coach1);

            Coach coach2 = new Coach();
            coach2.setFName("Emma");
            coach2.setSName("Johnson");
            coach2.setTeam(team2);
            team2.setCoach(coach2);

            session.save(coach1);
            session.save(coach2);

            // Create Players and assign them to teams
            Player player1 = new Player();
            player1.setFName("Alice");
            player1.setSName("Brown");
            player1.setTeam(team1);

            Player player2 = new Player();
            player2.setFName("Bob");
            player2.setSName("Green");
            player2.setTeam(team1);

            Player player3 = new Player();
            player3.setFName("Charlie");
            player3.setSName("White");
            player3.setTeam(team2);

            session.save(player1);
            session.save(player2);
            session.save(player3);

            // Create Positions for each player
            Position position1 = new Position();
            position1.setName("Goalkeeper");
            position1.setTime(90);
            position1.setPlayer(player1);

            Position position2 = new Position();
            position2.setName("Striker");
            position2.setTime(80);
            position2.setPlayer(player2);

            Position position3 = new Position();
            position3.setName("Left Wing");
            position3.setTime(75);
            position3.setPlayer(player3);

            session.save(position1);
            session.save(position2);
            session.save(position3);

            // Create Matches
            Match match1 = new Match();
            match1.setDate(LocalDate.of(2023, 7, 12));
            match1.setResult("2-1");
            match1.setStadium(stadium1);
            match1.setTeams(Arrays.asList(team1, team2));

            Match match2 = new Match();
            match2.setDate(LocalDate.of(2023, 7, 15));
            match2.setResult("1-1");
            match2.setStadium(stadium2);
            match2.setTeams(Arrays.asList(team1, team2));

            session.save(match1);
            session.save(match2);

            transaction.commit();
            System.out.println("Test data loaded successfully!");
            
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}

