package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.Syllabus;
import me.shafin.sustord.entities.TimeSlot;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(ClassRoutine.class)
public class ClassRoutine_ { 

    public static volatile SingularAttribute<ClassRoutine, Integer> year;
    public static volatile SingularAttribute<ClassRoutine, Syllabus> syllabusIdFk;
    public static volatile SingularAttribute<ClassRoutine, TimeSlot> timeSlotIdFk;
    public static volatile SingularAttribute<ClassRoutine, Integer> semester;
    public static volatile SingularAttribute<ClassRoutine, Integer> classRoutineId;

}