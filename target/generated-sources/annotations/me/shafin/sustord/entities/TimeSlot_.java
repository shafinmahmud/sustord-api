package me.shafin.sustord.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import me.shafin.sustord.entities.ClassRoutine;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-27T19:29:19")
@StaticMetamodel(TimeSlot.class)
public class TimeSlot_ { 

    public static volatile SingularAttribute<TimeSlot, Integer> timeSlotId;
    public static volatile SingularAttribute<TimeSlot, String> start;
    public static volatile SingularAttribute<TimeSlot, String> end;
    public static volatile SingularAttribute<TimeSlot, String> day;
    public static volatile CollectionAttribute<TimeSlot, ClassRoutine> classRoutineCollection;

}