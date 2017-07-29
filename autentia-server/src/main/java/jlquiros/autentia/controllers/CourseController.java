package jlquiros.autentia.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import jlquiros.autentia.form.CourseForm;
import jlquiros.autentia.form.SortForm;
import jlquiros.autentia.models.Course;
import jlquiros.autentia.services.CourseService;

@Component
@Path("/api/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;

    @GET
    @Produces({"application/json"})
    public List<Course> findActiveCourse(SortForm sort) {

    	 return courseService.findActiveCourses();
    }
    
    @POST
    @Consumes ({"application/json"})
    public void addCourse( CourseForm course) {
    	 courseService.insertCourse(course);
    }
    
    @Path("sort/{columnName}/{ascDesc}")
    @GET
	@Produces({ "application/json" })
	public List<Course> findActiveCourseSort(@PathParam("columnName") String column,
			@PathParam("ascDesc") String ascDesc) {
		SortForm sort = new SortForm(column, ascDesc);

		return courseService.findActiveCourses(sort);
	}
    
}