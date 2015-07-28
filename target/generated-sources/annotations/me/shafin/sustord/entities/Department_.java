package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.DegreeOffered;
import me.shafin.sustord.entities.School;
import me.shafin.sustord.entities.Syllabus;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile CollectionAttribute<Department, Syllabus> syllabusCollection;
    public static volatile SingularAttribute<Department, String> deptName;
    public static volatile CollectionAttribute<Department, DegreeOffered> degreeOfferedCollection;
    public static volatile SingularAttribute<Department, School> schoolIdFk;
    public static volatile SingularAttribute<Department, Integer> deptId;
    public static volatile CollectionAttribute<Department, Syllabus> syllabusCollection1;
    public static volatile SingularAttribute<Department, String> deptCode;

}