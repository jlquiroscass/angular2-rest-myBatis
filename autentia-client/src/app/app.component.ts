import { Component,OnInit, Directive, Output } from '@angular/core';

import {CourseDataService} from './services/api/course-data.service';
import {Course} from './model/course.entity';


import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {



  constructor(
     public router: Router
  ) {
  }




}