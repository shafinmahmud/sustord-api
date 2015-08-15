package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.StudentBatch;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.entities.Syllabus;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T00:59:09")
@StaticMetamodel(AdminDashboardCourseRegistration.class)
public class AdminDashboardCourseRegistration_ { 

    public static volatile SingularAttribute<AdminDashboardCourseRegistration, Integer> adminDashboardCourseRegistrationId;
    public static volatile SingularAttribute<AdminDashboardCourseRegistration, Short> approval;
    public static volatile SingularAttribute<AdminDashboardCourseRegistration, Syllabus> syllabusIdFk;
    public static volatile SingularAttribute<AdminDashboardCourseRegistration, String> grade;
    public static volatile SingularAttribute<AdminDashboardCourseRegistration, StudentBatch> studentBatchIdFk;
    public static volatile SingularAttribute<AdminDashboardCourseRegistration, StudentInfo> studentInfoIdFk;
    public static volatile SingularAttribute<AdminDashboardCourseRegistration, Integer> intakeSemester;

}