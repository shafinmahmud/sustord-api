package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.StudentBatch;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(AdminInfo.class)
public class AdminInfo_ { 

    public static volatile SingularAttribute<AdminInfo, String> adminNo;
    public static volatile SingularAttribute<AdminInfo, String> password;
    public static volatile SingularAttribute<AdminInfo, StudentBatch> studentBatchIdFk;
    public static volatile SingularAttribute<AdminInfo, Integer> adminInfoId;

}