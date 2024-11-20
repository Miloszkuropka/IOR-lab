package metaM;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import model.Player;


@StaticMetamodel(Player.class)
public abstract class Player_ extends metaM.Person_ {

    public static final String POSITION = "position";
    public static final String NUMBER = "number";
    public static final String TEAM = "team";

    /**
     * @see model.Player#position
     **/
    public static volatile SingularAttribute<Player, String> position;

    /**
     * @see model.Player#number
     **/
    public static volatile SingularAttribute<Player, Integer> number;

    /**
     * @see model.Player#team
     **/
    public static volatile SingularAttribute<Player, model.Team> team;

    /**
     * @see model.Player
     **/
    public static volatile EntityType<Player> class_;
}


