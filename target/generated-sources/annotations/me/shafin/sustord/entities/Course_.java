package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.Prerequisite;
import me.shafin.sustord.entities.Syllabus;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile CollectionAttribute<Course, Syllabus> syllabusCollection;
    public static volatile SingularAttribute<Course, String> references;
    public static volatile SingularAttribute<Course, String> courseCode;
    public static volatile SingularAttribute<Course, String> title;
    public static volatile SingularAttribute<Course, Double> credit;
    public static volatile SingularAttribute<Course, Integer> courseId;
    public static volatile SingularAttribute<Course, Short> theoryOrLab;
    public static volatile SingularAttribute<Course, String> content;
    public static volatile CollectionAttribute<Course, Prerequisite> prerequisiteCollection;

}