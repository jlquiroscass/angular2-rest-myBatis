import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Course } from '../../model/course.entity';

import { PagerService } from '../../services/pager.service'
import {CourseDataService} from '../../services/api/course-data.service';
import { ApiService } from '../../services/api/api.service';
import { HttpModule } from '@angular/http';

@Component({
  selector: 'table-courses-list',
  templateUrl: './table-courses.component.html',
  styleUrls: ['./table-courses.component.css'],
  providers: [CourseDataService,PagerService,ApiService]
})
export class TableCoursesComponent {
        
  courses: Course[] = [];
    
  // pager object
  pager: any = {};

  // paged items
  pagedItems: any[];
    
        
  sortNameASC : boolean = false;
  nameAscDesc : string = 'DESC';
  sortLevelASC : boolean = false;
  levelAscDesc : string = 'DESC';
  sortHoursASC : boolean = false;
  hoursAscDesc : string = 'DESC';
  sortProfASC : boolean = false;
  profAscDesc : string = 'DESC';
    
  constructor(
    private courseDataService: CourseDataService, private pagerService: PagerService
  ) {
  }

    //GET ALL THE COURSES ACTIVE TO FILL THE TABLE
public ngOnInit() {
    this.courseDataService
      .getAllCourses()
      .subscribe(
        (courses) => {
          this.courses = courses;
            //SET PAGINATION
          this.setPage(1);
        }
      );
  }
    //ORDER BY NAME
    orderName(){
      this.sortNameASC = !this.sortNameASC;
      if (this.sortNameASC)
        this.nameAscDesc = "ASC";
      else
         this.nameAscDesc = "DESC";
      this.sorting("NAME", this.nameAscDesc);      
  }
    //ORDER BY LEVEL
    orderLevel(){
      this.sortLevelASC = !this.sortLevelASC;
      if (this.sortLevelASC)
        this.levelAscDesc = "ASC";
      else
         this.levelAscDesc = "DESC";
      this.sorting("LEVEL", this.levelAscDesc);      
  }
    //ORDER BY HOURS
    orderHours(){
      this.sortHoursASC = !this.sortHoursASC;
      if (this.sortHoursASC)
        this.hoursAscDesc = "ASC";
      else
         this.hoursAscDesc = "DESC";
      this.sorting("NUMHOURS", this.hoursAscDesc);      
  }
  //ORDER BY PROFESSOR
     orderProfessor(){
      this.sortProfASC = !this.sortProfASC;
      if (this.sortProfASC)
        this.profAscDesc = "ASC";
      else
         this.profAscDesc = "DESC";
      this.sorting("PROF", this.profAscDesc);
      
  }
    
  //ORDER COLUMNS BY COLUMNNAME AND ASCDESC
  sorting(column:string, sortASC:string){
      this.courseDataService
      .getAllCoursesSort(column, sortASC)
      .subscribe(
         (courses) => {
          this.courses = courses;
          this.setPage(1);
        }
      );
      }
    
    //SET PAGE ON PAGINATION
     setPage(page: number) {
        if (page < 1 || page > this.pager.totalPages) {
            return;
        }

        this.pager = this.pagerService.getPager(this.courses.length, page);

        this.pagedItems = this.courses.slice(this.pager.startIndex, this.pager.endIndex + 1);
    }
   
}