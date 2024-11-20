package model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Coach.class)
public abstract class Coach_ extends model.Person_ {

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

