package Entity;

import Entity.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2563-11-16T15:32:59")
@StaticMetamodel(Directors.class)
public class Directors_ { 

    public static volatile SingularAttribute<Directors, String> directorFname;
    public static volatile SingularAttribute<Directors, String> directorLname;
    public static volatile SingularAttribute<Directors, Integer> directorID;
    public static volatile ListAttribute<Directors, Movie> movieList;

}