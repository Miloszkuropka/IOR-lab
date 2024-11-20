package model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Position.class)
public abstract class Position_ extends model.Player_ {

	public static final String NAME = "name";
	public static final String TIME = "time";

	
	/**
	 * @see model.Position#name
	 **/
	public static volatile SingularAttribute<Position, String> name;
	
	/**
	 * @see model.Position#time
	 **/
	public static volatile SingularAttribute<Position, Integer> time;
	
	/**
	 * @see model.Position
	 **/
	public static volatile EntityType<Position> class_;

}

