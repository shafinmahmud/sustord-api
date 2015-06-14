package me.shafin.sustord.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.shafin.sustord.models.StudentPersonal;
import me.shafin.sustord.models.Student;
import me.shafin.sustord.services.PersonalInfoService;

@Path("/info")
public class InfomationResouces {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentData() {
		
		List<Student> students = new ArrayList<Student>();
		PersonalInfoService infoService;
		try {
			infoService = new PersonalInfoService("2011331001");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		StudentPersonal student = new StudentPersonal();
		
		student.setName(infoService.getStudentName());
		student.setRegistrationNo("2011331001");
		
		students.add(student);
		return students;
	}
}
