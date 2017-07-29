package jlquiros.autentia.servicesImpl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import jlquiros.autentia.form.CourseForm;
import jlquiros.autentia.form.SortForm;
import jlquiros.autentia.mappers.CourseMapper;
import jlquiros.autentia.mappers.ProfessorMapper;
import jlquiros.autentia.models.Course;
import jlquiros.autentia.models.Professor;
import jlquiros.autentia.models.TypesSort;
import jlquiros.autentia.services.CourseService;

@Service
@Qualifier("courseService")
public class CourseServiceImpl implements CourseService{
	

	@Autowired
	CourseMapper courseMapper;
	
	@Autowired
	ProfessorMapper professorMapper;
	
	public List<Course> findCourses(){
		List<Course> list = courseMapper.findAllCourses();
		return list;
	}
	
	public Course findCourse( int id){
		return courseMapper.findCourseById(id);
	}
	
	public List<Course> findActiveCourses(){
		return courseMapper.findAllCoursesByActive();
	}
	
	public List<Course> findActiveCourses(SortForm sortForm){
		if (sortForm == null)
			return courseMapper.findAllCoursesByActive();
		
		TypesSort typeSort = TypesSort.valueOf(sortForm.getColumnName() + sortForm.getAscDesc());
    	switch (typeSort){
	    	case NAMEASC:
	    		return courseMapper.findAllCoursesByActiveSortedNameAsc();
	    	case NAMEDESC:
	    		return courseMapper.findAllCoursesByActiveSortedNameDESC();
	    	case LEVELASC:
	    		return courseMapper.findAllCoursesByActiveSortedLevelAsc();
	    	case LEVELDESC:
	    		return courseMapper.findAllCoursesByActiveSortedLevelDESC();
	    	case NUMHOURSASC:
	    		return courseMapper.findAllCoursesByActiveSortedNumHoursAsc();
	    	case NUMHOURSDESC:
	    		return courseMapper.findAllCoursesByActiveSortedNumHoursDesc();
	    	case PROFASC:
	    		return courseMapper.findAllCoursesByActiveSortedProfAsc();
	    	case PROFDESC:
	    		return courseMapper.findAllCoursesByActiveSortedProfDesc();
	    	default:
	    		return courseMapper.findAllCoursesByActive();
	    			
    	}
		
	}
	
	public List<Professor> findAllProfessors(){
		return professorMapper.findAllProfessor();
	}
	
	public void insertCourse(CourseForm course){
		Course courseModel = new Course();
		courseModel.setLevel(course.getLevel());
		courseModel.setName(course.getName());
		courseModel.setActive(course.getActive());
		courseModel.setNumHours(course.getNumHours());
		courseModel.setProfessor(professorMapper.findProfessorById(course.getProfessor_id()));
		courseMapper.insertCourse(courseModel);
	}

}
