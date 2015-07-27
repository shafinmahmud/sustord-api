/*
 */
package me.shafin.sustord.helpers;

import java.util.ArrayList;
import java.util.List;
import me.shafin.sustord.entities.CourseRegistration;
import me.shafin.sustord.models.Report;
import me.shafin.sustord.utilities.ModelConstants;

/**
 *
 * @author SHAFIN
 */
public class ReportHelper {
    
    public static String getCourseStatusFromResults(List<Report> results) {
        String courseStatus;
        boolean passedFlag = false;
        boolean pendingFlag = false;

        if (results != null) {
            System.out.println("ya its :/");
            for (Report r : results) {
                if (!r.getGrade().getGradeLetter().equals("N/A")) {
                    if (r.getGrade().getGradePoint() > 0.00) {
                        passedFlag = true;
                    }
                } else {
                    pendingFlag = true;
                }
            }

            if (passedFlag) {
                courseStatus = ModelConstants.PASSED;
            } else if (!pendingFlag) {
                courseStatus = ModelConstants.FAILED;
            } else {
                courseStatus = ModelConstants.RESULT_PENDING;
            }
        } else {
            courseStatus = ModelConstants.NOT_ATTENDED;
        }
        return courseStatus;
    }
    
    public static String getPassingSemesterOfCourse(List<Report> results) {
        if (results != null) {
            for (Report r : results) {
                if (r.getGrade() != null) {
                    if (r.getGrade().getGradePoint() > 0.00) {
                        int sem = r.getAttendedSemester();
                        return Integer.toString(sem);
                    }
                }
            }
        }
        return "";
    }
    
    
    public static List<CourseRegistration> getUniqueRegistrationsWithLastAttend
        (List<CourseRegistration> allRegistrations){
            List<CourseRegistration> uniqueCourseRegistrations = new ArrayList<>();
            
            for(CourseRegistration a:allRegistrations){
                boolean foundFlag = false;
                CourseRegistration f = a;
                
                for(CourseRegistration u:uniqueCourseRegistrations){
                    if(u.getSyllabusIdFk() == a.getSyllabusIdFk()){
                        foundFlag = true;
                        f = u;
                    }
                }
                
                if(!foundFlag){
                    uniqueCourseRegistrations.add(a);
                    //System.out.println(a.getSyllabusIdFk().getCourseIdFk().getCourseCode() + " : "+a.getAttendSemester());
                }else{
                    if(a.getAttendSemester() >= f.getAttendSemester()){
                        uniqueCourseRegistrations.remove(f);
                        uniqueCourseRegistrations.add(a);
                    }
                }
            }
            
        return uniqueCourseRegistrations;
    }
    
    
    public static boolean isCourseRegistationRegular(CourseRegistration reg) {
        return reg.getAttendSemester() == reg.getSyllabusIdFk().getSemester();
    }
}
