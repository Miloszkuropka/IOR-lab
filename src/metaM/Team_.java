package metaM;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import model.Team;
import model.Match;
import model.Coach;
import model.Player;


@StaticMetamodel(Team.class)
public abstract class Team_ {

    public static final String NAME = "name";
    public static final String COUNTRY = "country";
    public static final String COACH = "coach";
    public static final String PLAYERS = "players";
    public static final String MATCHES = "matches";

    /**
     * @see model.Team#name
     **/
    public static volatile SingularAttribute<Team, String> name;

    /**
     * @see model.Team#country
     **/
    public static volatile SingularAttribute<Team, String> country;

    /**
     * @see model.Team#coach
     **/
    public static volatile SingularAttribute<Team, Coach> coach;

    /**
     * @see model.Team#players
     **/
    public static volatile SetAttribute<Team, Player> players;

    /**
     * @see model.Team#matches
     **/
    public static volatile SetAttribute<Team, Match> matches;

   /**
     * @see model.Team
     **/
    public static volatile EntityType<Team> class_;
}

