package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.DegreeOffered;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T00:59:09")
@StaticMetamodel(Degree.class)
public class Degree_ { 

    public static volatile SingularAttribute<Degree, Integer> degreeId;
    public static volatile CollectionAttribute<Degree, DegreeOffered> degreeOfferedCollection;
    public static volatile SingularAttribute<Degree, String> degreeType;
    public static volatile SingularAttribute<Degree, String> degreeCategory;
    public static volatile SingularAttribute<Degree, String> degreeTypeName;
    public static volatile SingularAttribute<Degree, Integer> totalSemester;

}