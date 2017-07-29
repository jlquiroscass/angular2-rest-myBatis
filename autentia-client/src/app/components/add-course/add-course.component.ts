import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {Router} from '@angular/router'

import { Professor } from '../../model/professor.entity';
import { Course } from '../../model/course.entity';

import {CourseDataService} from '../../services/api/course-data.service';

@Component({
  selector: 'add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css'],
  providers: [CourseDataService]
})
export class AddCourseComponent {
        
  professors : Professor[] = [];
  course : Course = new Course({
    });
    
  complexForm : FormGroup;
  
        
  //Validator of the form  
  constructor(private courseDataService: CourseDataService,fb: FormBuilder,private router: Router
  ) {
      this.complexForm = fb.group({
      'name' : [null, Validators.required],
      'level': [null, Validators.required],
      'professor_id' : [null,Validators.required],
      'numHours' : [null, Validators.compose([Validators.required,Validators.pattern('^[0-9]*$')])],
      'active' : false
    })
  }
    //Get All the Professsors to fill the select
    public ngOnInit() {
    this.courseDataService
      .getAllProfessors()
      .subscribe(
        (professors) => {
          this.professors = professors;
        }
      );
  }
   
    //NOT IN USE
   public submitForm() {
     //Add course to the list  
    this.courseDataService.addCourse(this.course)
        .subscribe((dataResponse) => {
            console.log("exec" + this.course);
        });
       
}
      //Add course to the list 
   onSubmit(form: Course): void {  
    console.log('you submitted value:', form); 
    this.courseDataService.addCourse(form)
        .subscribe((dataResponse) => {
            console.log("exec" + this.course);
        });
     //Return to the main page
    this.router.navigateByUrl('courses');
  }
   
  onChangeDoc(event) {
    console.log('onChange');
    var files = event.srcElement.files;
    console.log(files);
    this.courseDataService.makeFileRequest( [], files)
    .subscribe(() => {
      console.log('sent');
    });
  }

   
}