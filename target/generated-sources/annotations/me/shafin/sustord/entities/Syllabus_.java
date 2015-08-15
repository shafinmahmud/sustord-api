package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.AdminDashboardCourseRegistration;
import me.shafin.sustord.entities.ClassRoutine;
import me.shafin.sustord.entities.Course;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.entities.Department;
import me.shafin.sustord.entities.Prerequisite;
import me.shafin.sustord.entities.StudentBatch;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T00:59:09")
@StaticMetamodel(Syllabus.class)
public class Syllabus_ { 

    public static volatile SingularAttribute<Syllabus, Double> hrsWeek;
    public static volatile SingularAttribute<Syllabus, Integer> syllabusId;
    public static volatile SingularAttribute<Syllabus, Course> courseIdFk;
    public static volatile SingularAttribute<Syllabus, StudentBatch> studentBatchIdFk;
    public static volatile SingularAttribute<Syllabus, Integer> semester;
    public static volatile CollectionAttribute<Syllabus, ClassRoutine> classRoutineCollection;
    public static volatile SingularAttribute<Syllabus, Department> offeringDeptIdFk;
    public static volatile SingularAttribute<Syllabus, String> remarks;
    public static volatile CollectionAttribute<Syllabus, Prerequisite> prerequisiteCollection;
    public static volatile CollectionAttribute<Syllabus, AdminDashboardCourseRegistration> adminDashboardCourseRegistrationCollection;
    public static volatile SingularAttribute<Syllabus, Department> acceptingDeptIdFk;
    public static volatile CollectionAttribute<Syllabus, CourseRegistration> courseRegistrationCollection;

}