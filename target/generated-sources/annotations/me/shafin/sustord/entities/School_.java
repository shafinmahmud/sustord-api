package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.Department;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(School.class)
public class School_ { 

    public static volatile SingularAttribute<School, Integer> schoolId;
    public static volatile SingularAttribute<School, String> schoolName;
    public static volatile CollectionAttribute<School, Department> departmentCollection;

}