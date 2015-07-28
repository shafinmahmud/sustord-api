package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.entities.Syllabus;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(CourseRegistration.class)
public class CourseRegistration_ { 

    public static volatile SingularAttribute<CourseRegistration, Integer> attendYear;
    public static volatile SingularAttribute<CourseRegistration, Integer> approval;
    public static volatile SingularAttribute<CourseRegistration, Syllabus> syllabusIdFk;
    public static volatile SingularAttribute<CourseRegistration, String> grade;
    public static volatile SingularAttribute<CourseRegistration, Integer> attendSemester;
    public static volatile SingularAttribute<CourseRegistration, StudentInfo> studentInfoIdFk;
    public static volatile SingularAttribute<CourseRegistration, Integer> courseRegistrationId;

}