package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.StudentInfo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-08-16T00:59:09")
@StaticMetamodel(PersonalInfo.class)
public class PersonalInfo_ { 

    public static volatile SingularAttribute<PersonalInfo, String> fathersName;
    public static volatile SingularAttribute<PersonalInfo, String> sex;
    public static volatile SingularAttribute<PersonalInfo, String> dateOfBirth;
    public static volatile SingularAttribute<PersonalInfo, String> religion;
    public static volatile SingularAttribute<PersonalInfo, String> bloodGroup;
    public static volatile SingularAttribute<PersonalInfo, String> photoUrl;
    public static volatile SingularAttribute<PersonalInfo, String> nationality;
    public static volatile SingularAttribute<PersonalInfo, String> presentAddress;
    public static volatile SingularAttribute<PersonalInfo, String> mothersName;
    public static volatile SingularAttribute<PersonalInfo, String> contact;
    public static volatile SingularAttribute<PersonalInfo, String> name;
    public static volatile SingularAttribute<PersonalInfo, String> permanentAddress;
    public static volatile SingularAttribute<PersonalInfo, StudentInfo> studentInfoIdFk;
    public static volatile SingularAttribute<PersonalInfo, Integer> personalInfoId;
    public static volatile SingularAttribute<PersonalInfo, String> maritalStatus;
    public static volatile SingularAttribute<PersonalInfo, String> email;

}