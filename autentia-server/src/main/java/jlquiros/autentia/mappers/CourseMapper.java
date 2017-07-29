package jlquiros.autentia.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;

import jlquiros.autentia.form.SortForm;
import jlquiros.autentia.models.Course;
import jlquiros.autentia.models.Professor;


public interface  CourseMapper {

    @Insert("insert into course(active,name,num_hours,level,professor_id) values(#{active},#{name},#{numHours},#{level},#{professorId})")
	 void insertCourse(Course course);
	
    @Select("SELECT * FROM course c JOIN professor p on p.professor_id=c.professor_id and c.id=#{id}")
    @ResultMap ("courseResult")
    Course findCourseById(Integer id);
    
    @Select("SELECT * FROM course c JOIN professor p on p.professor_id=c.professor_id")
    @ResultMap ("courseResult")
	 List<Course> findAllCourses();
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ")
    @ResultMap ("courseResult")
     List<Course> findAllCoursesByActive();
   
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY name ASC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedNameAsc();
    
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY name DESC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedNameDESC();
    
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY level ASC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedLevelAsc();
    
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY level DESC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedLevelDESC();
    
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY num_hours ASC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedNumHoursAsc();
    
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY num_hours DESC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedNumHoursDesc();
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY p.first_name ASC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedProfAsc();
    
    
    @Select("SELECT * FROM course c JOIN professor p on	p.professor_id=c.professor_id and c.active='A' ORDER BY p.first_name DESC ")
    @ResultMap ("courseResult")
	 List<Course> findAllCoursesByActiveSortedProfDesc();


    
    
}
