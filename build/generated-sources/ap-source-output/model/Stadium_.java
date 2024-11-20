package model;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Stadium.class)
public abstract class Stadium_ {

	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String ID = "id";

	
	/**
	 * @see model.Stadium#name
	 **/
	public static volatile SingularAttribute<Stadium, String> name;
	
	/**
	 * @see model.Stadium#location
	 **/
	public static volatile SingularAttribute<Stadium, String> location;
	
	/**
	 * @see model.Stadium#id
	 **/
	public static volatile SingularAttribute<Stadium, Integer> id;
	
	/**
	 * @see model.Stadium
	 **/
	public static volatile EntityType<Stadium> class_;

}

