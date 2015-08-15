package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.AdminDashboardCourseRegistration;
import me.shafin.sustord.entities.AdminDashboardProfile;
import me.shafin.sustord.entities.AdminInfo;
import me.shafin.sustord.entities.DegreeOffered;
import me.shafin.sustord.entities.StudentInfo;
import me.shafin.sustord.entities.Syllabus;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T00:59:09")
@StaticMetamodel(StudentBatch.class)
public class StudentBatch_ { 

    public static volatile CollectionAttribute<StudentBatch, Syllabus> syllabusCollection;
    public static volatile SingularAttribute<StudentBatch, DegreeOffered> degreeOfferedIdFk;
    public static volatile SingularAttribute<StudentBatch, String> batchTag;
    public static volatile CollectionAttribute<StudentBatch, AdminInfo> adminInfoCollection;
    public static volatile SingularAttribute<StudentBatch, String> session;
    public static volatile SingularAttribute<StudentBatch, Integer> maxSemester;
    public static volatile SingularAttribute<StudentBatch, Integer> studentBatchId;
    public static volatile CollectionAttribute<StudentBatch, AdminDashboardProfile> adminDashboardProfileCollection;
    public static volatile CollectionAttribute<StudentBatch, AdminDashboardCourseRegistration> adminDashboardCourseRegistrationCollection;
    public static volatile CollectionAttribute<StudentBatch, StudentInfo> studentInfoCollection;

}