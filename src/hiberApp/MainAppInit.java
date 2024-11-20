/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Class initializing the application
 * 
 * @author LabHiber
 */

public final class MainAppInit {

    static final Map<String, String> props = new HashMap<>();

    static {
        // Automatyczne tworzenie i usuwanie schematu bazy danych
        props.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");
    }
    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU", props);

    public static void main(String[] args) {
        
        // Załadowanie danych testowych
        final DataLoad dataLoad = new DataLoad();
        dataLoad.createData(FACTORY);
        
       // Wyświetlenie danych z bazy
        final DataQueries dataQueries = new DataQueries();
        dataQueries.showAll(FACTORY);
       
        
        System.out.println("List of :");
        dataQueries.showPersons(FACTORY);

        System.out.println("\nList of Teams:");
        dataQueries.showTeams(FACTORY);

        System.out.println("\nList of Matches:");
        dataQueries.showMatches(FACTORY);
    }
}


