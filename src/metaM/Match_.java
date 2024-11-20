package metaM;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import model.Team;
import model.Match;
import model.Stadium;



@StaticMetamodel(Match.class)
public abstract class Match_ {

    public static final String DATE = "date";
    public static final String RESULT = "result";
    public static final String HOME_TEAM = "homeTeam";
    public static final String AWAY_TEAM = "awayTeam";
    public static final String STADIUM = "stadium";
    public static final String ID = "id";

    /**
     * @see model.Match#date
     **/
    public static volatile SingularAttribute<Match, LocalDate> date;

    /**
     * @see model.Match#result
     **/
    public static volatile SingularAttribute<Match, String> result;

    /**
     * @see model.Match#homeTeam
     **/
    public static volatile SingularAttribute<Match, Team> homeTeam;

    /**
     * @see model.Match#awayTeam
     **/
    public static volatile SingularAttribute<Match, Team> awayTeam;

    /**
     * @see model.Match#stadium
     **/
    public static volatile SingularAttribute<Match, Stadium> stadium;

    /**
     * @see model.Match#id
     **/
    public static volatile SingularAttribute<Match, Integer> id;

    /**
     * @see model.Match
     **/
    public static volatile EntityType<Match> class_;
}



