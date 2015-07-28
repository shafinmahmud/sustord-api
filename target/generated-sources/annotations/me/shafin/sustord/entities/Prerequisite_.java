package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.Course;
import me.shafin.sustord.entities.Syllabus;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(Prerequisite.class)
public class Prerequisite_ { 

    public static volatile SingularAttribute<Prerequisite, Integer> prerequisiteId;
    public static volatile SingularAttribute<Prerequisite, Syllabus> syllabusIdFk;
    public static volatile SingularAttribute<Prerequisite, Course> courseIdFk;

}