import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { TableCoursesComponent } from './components/table-courses/table-courses.component';
import { AddCourseComponent } from './components/add-course/add-course.component';
import { ApiService } from './services/api/api.service';

const appRoutes: Routes = [
  { path: 'courses', component: TableCoursesComponent },
  { path: '', component: TableCoursesComponent },
  { path: 'add', component: AddCourseComponent }];
    
@NgModule({
  declarations: [
    AppComponent,
    TableCoursesComponent,
    AddCourseComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } 
    ),
    ReactiveFormsModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
