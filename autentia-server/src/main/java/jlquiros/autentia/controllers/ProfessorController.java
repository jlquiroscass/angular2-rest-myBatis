package jlquiros.autentia.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jlquiros.autentia.models.Course;
import jlquiros.autentia.models.Professor;
import jlquiros.autentia.services.CourseService;

@Component
@Path("/api/professor")
public class ProfessorController {
	
	@Autowired
	CourseService courseService;

    @GET
    @Produces({"application/json"})
    public List<Professor> getAllProfessors() {
    	 return courseService.findAllProfessors();
    }
    
}