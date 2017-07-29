import { TestBed, inject } from '@angular/core/testing';

import { CourseDataService } from './course-data.service';
import {Course} from '../../model/course.entity';
import {HttpModule} from '@angular/http';

import { ApiService } from './api.service';

describe('CourseDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CourseDataService,ApiService],
      imports: [ HttpModule]
    });
  });

  it('should be created', inject([CourseDataService], (service: CourseDataService) => {
    expect(service).toBeTruthy();
  }));
    
/*  describe('#getAllCourses()', () => {

    it('should return an empty array by default', inject([CourseDataService], (service: CourseDataService) => {
      expect(service.getAllCourses()).toEqual([]);
    }));

    it('should return all courses', inject([CourseDataService], (service: CourseDataService) => {
      let course1 = new Course({name: 'Java 101', numHours: 10 , level: 'basic' , professor: 'Hawkings'});
      let course2 = new Course({name: 'Java 102', numHours: 11 , level: 'basic' , professor: 'Sr. Rodigriguez'});
      service.addCourse(course1);
      service.addCourse(course2);
      expect(service.getAllCourses()).toEqual([course1, course2]);
    }));
      
  });*/
      
  /*  describe('#save(course)', () => {

    it('should automatically assign an incrementing id',  inject([CourseDataService], (service: CourseDataService) => {
      let course1 = new Course({name: 'Java 101', numHours: 10 , level: 'basic' , professor: 'Hawkings'});
      let course2 = new Course({name: 'Java 102', numHours: 11 , level: 'basic' , professor: 'Sr. Rodigriguez'});
      service.addCourse(course1);
      service.addCourse(course2);
      expect(service.getCourseById(1)).toEqual(course1);
      expect(service.getCourseById(2)).toEqual(course2);
    }));
  });*/
  


    
});
