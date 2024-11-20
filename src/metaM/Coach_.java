package metaM;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import model.Team;
import model.Coach;




@StaticMetamodel(Coach.class)
public abstract class Coach_ extends metaM.Person_ {

    public static final String TEAM = "team";

    /**
     * @see model.Coach#team
     **/
    public static volatile SingularAttribute<Coach, Team> team;

    /**
     * @see model.Coach
     **/
    public static volatile EntityType<Coach> class_;
}


