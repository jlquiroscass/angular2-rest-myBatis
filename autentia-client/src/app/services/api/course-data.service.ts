import { Injectable } from '@angular/core';
import {Course} from '../../model/course.entity';
import {Professor} from '../../model/professor.entity';
import { ApiService } from './api.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CourseDataService {
        
  lastId: number = 0;

  courses: Course[] = [];

  constructor(
    private api: ApiService
  ) {
  }
    
  getAllCourses():  Observable<Course[]> {
    return this.api.getAllCourses();
  }
    
  getAllCoursesSort(column : string, sortASC: string) :  Observable<Course[]> {
    return this.api.getAllCoursesSort(column, sortASC);
  }
  
  getAllProfessors() : Observable<Professor[]> {
      return this.api.getAllProfessors();
  }
   
  addCourse(course: Course): Observable<Course[]> {
      return this.api.createCourse(course);
  }
  
  makeFileRequest( params: string[], files: File[]) : Observable<string> {
      return this.api.makeFileRequest(params,files);
  }


}
