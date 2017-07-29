package jlquiros.autentia.services;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jlquiros.autentia.form.CourseForm;
import jlquiros.autentia.form.SortForm;
import jlquiros.autentia.mappers.CourseMapper;
import jlquiros.autentia.models.Course;
import jlquiros.autentia.models.Professor;


@Service
public interface CourseService {
	
	public List<Course> findCourses();
	
	public Course findCourse( int id);
	
	public List<Course> findActiveCourses();
	
	public List<Course> findActiveCourses(SortForm sortForm);

	public List<Professor> findAllProfessors();
	
	public void insertCourse(CourseForm course);
	

}
