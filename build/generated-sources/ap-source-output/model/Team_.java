package model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Set;

@StaticMetamodel(Team.class)
public abstract class Team_ {

	public static final String COUNTRY = "country";
	public static final String PLAYERS = "players";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String MATCHES = "matches";

	
	/**
	 * @see model.Team#country
	 **/
	public static volatile SingularAttribute<Team, String> country;
	
	/**
	 * @see model.Team#players
	 **/
	public static volatile SetAttribute<Team, Player> players;
	
	/**
	 * @see model.Team#name
	 **/
	public static volatile SingularAttribute<Team, String> name;
	
	/**
	 * @see model.Team#id
	 **/
	public static volatile SingularAttribute<Team, Integer> id;
	
	/**
	 * @see model.Team
	 **/
	public static volatile EntityType<Team> class_;
	
	/**
	 * @see model.Team#matches
	 **/
	public static volatile SingularAttribute<Team, Set<Match>> matches;

}

