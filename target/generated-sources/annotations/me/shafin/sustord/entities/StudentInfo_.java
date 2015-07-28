package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.AdminDashboardCourseRegistration;
import me.shafin.sustord.entities.AdminDashboardProfile;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.entities.PersonalInfo;
import me.shafin.sustord.entities.StudentBatch;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(StudentInfo.class)
public class StudentInfo_ { 

    public static volatile SingularAttribute<StudentInfo, Integer> studentInfoId;
    public static volatile SingularAttribute<StudentInfo, PersonalInfo> personalInfo;
    public static volatile SingularAttribute<StudentInfo, String> password;
    public static volatile SingularAttribute<StudentInfo, String> registrationNo;
    public static volatile SingularAttribute<StudentInfo, StudentBatch> studentBatchIdFk;
    public static volatile CollectionAttribute<StudentInfo, AdminDashboardProfile> adminDashboardProfileCollection;
    public static volatile CollectionAttribute<StudentInfo, AdminDashboardCourseRegistration> adminDashboardCourseRegistrationCollection;
    public static volatile CollectionAttribute<StudentInfo, CourseRegistration> courseRegistrationCollection;

}