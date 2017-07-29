package jlquiros.autentia.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import jlquiros.autentia.models.Professor;


public interface  ProfessorMapper {

    @Insert("insert into professor(name,last_name) values(#{name},#{lastName})")
    @SelectKey(statement="call identity()", keyProperty="id",
    before=false, resultType=Integer.class)
	 void insertProfessor(Professor professor);
	
    @Select("select * from professor WHERE professor_id=#{id}")	
    @ResultMap ("professorResult")
	 Professor findProfessorById(Integer id);
    
    @Select("select * from professor")
    @ResultMap ("professorResult")
	 List<Professor> findAllProfessor();
}
