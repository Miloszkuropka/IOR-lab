package model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Player.class)
public abstract class Player_ extends model.Person_ {

	public static final String NUMBER = "number";
	public static final String POSITIONS = "positions";
	public static final String TEAM = "team";
	public static final String POSITION = "position";

	
	/**
	 * @see model.Player#number
	 **/
	public static volatile SingularAttribute<Player, Integer> number;
	
	/**
	 * @see model.Player#positions
	 **/
	public static volatile SetAttribute<Player, Position> positions;
	
	/**
	 * @see model.Player#team
	 **/
	public static volatile SingularAttribute<Player, Team> team;
	
	/**
	 * @see model.Player#position
	 **/
	public static volatile SingularAttribute<Player, String> position;
	
	/**
	 * @see model.Player
	 **/
	public static volatile EntityType<Player> class_;

}

