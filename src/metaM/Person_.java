package metaM;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import model.Person;



@StaticMetamodel(Person.class)
public abstract class Person_ {

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String ID = "id";

    /**
     * @see model.Person#firstName
     **/
    public static volatile SingularAttribute<Person, String> firstName;

    /**
     * @see model.Person#lastName
     **/
    public static volatile SingularAttribute<Person, String> lastName;

    /**
     * @see model.Person#id
     **/
    public static volatile SingularAttribute<Person, Integer> id;

    /**
     * @see model.Person
     **/
    public static volatile EntityType<Person> class_;
}


