package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.StudentBatch;
import me.shafin.sustord.entities.StudentInfo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T00:59:09")
@StaticMetamodel(AdminDashboardProfile.class)
public class AdminDashboardProfile_ { 

    public static volatile SingularAttribute<AdminDashboardProfile, String> fathersName;
    public static volatile SingularAttribute<AdminDashboardProfile, Integer> adminDashboardProfileId;
    public static volatile SingularAttribute<AdminDashboardProfile, Short> approval;
    public static volatile SingularAttribute<AdminDashboardProfile, String> sex;
    public static volatile SingularAttribute<AdminDashboardProfile, byte[]> photo;
    public static volatile SingularAttribute<AdminDashboardProfile, StudentBatch> studentBatchIdFk;
    public static volatile SingularAttribute<AdminDashboardProfile, String> dateOfBirth;
    public static volatile SingularAttribute<AdminDashboardProfile, String> religion;
    public static volatile SingularAttribute<AdminDashboardProfile, String> bloodGroup;
    public static volatile SingularAttribute<AdminDashboardProfile, String> nationality;
    public static volatile SingularAttribute<AdminDashboardProfile, String> presentAddress;
    public static volatile SingularAttribute<AdminDashboardProfile, String> mothersName;
    public static volatile SingularAttribute<AdminDashboardProfile, String> contact;
    public static volatile SingularAttribute<AdminDashboardProfile, String> name;
    public static volatile SingularAttribute<AdminDashboardProfile, String> permanentAddress;
    public static volatile SingularAttribute<AdminDashboardProfile, StudentInfo> studentInfoIdFk;
    public static volatile SingularAttribute<AdminDashboardProfile, String> maritalStatus;
    public static volatile SingularAttribute<AdminDashboardProfile, String> email;

}