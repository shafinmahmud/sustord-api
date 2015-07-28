package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.Degree;
import me.shafin.sustord.entities.Department;
import me.shafin.sustord.entities.StudentBatch;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(DegreeOffered.class)
public class DegreeOffered_ { 

    public static volatile SingularAttribute<DegreeOffered, Integer> degreeOfferedId;
    public static volatile CollectionAttribute<DegreeOffered, StudentBatch> studentBatchCollection;
    public static volatile SingularAttribute<DegreeOffered, Degree> degreeIdFk;
    public static volatile SingularAttribute<DegreeOffered, Department> deptIdFk;

}