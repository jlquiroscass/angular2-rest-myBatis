import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';

import { Http, Response, Headers } from '@angular/http';
import { Course } from '../../model/course.entity';
import { Professor } from '../../model/professor.entity';
import { SortForm } from '../../model/sort.entity';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

const API_URL = environment.apiUrl;

@Injectable()
export class ApiService {

  constructor(
    private http: Http
  ) {
  }
    
  private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }

  // API: GET /api/course
  public getAllCourses() {
    return this.http
    .get(API_URL + '/api/course')
    .map(response => {
      const courses = response.json();
      return courses.map((course) => new Course(course));
    })
    .catch(this.handleError);
  }
 
  // API: GET /api/course/sort/{columnName}/{ascDesc}
  public getAllCoursesSort(column: string, sortASC : string) {
    let sort = new SortForm ({columnName: column,ascDesc: sortASC});
    return this.http
    .get(API_URL + '/api/course/sort/' + column + "/" +  sortASC)
    .map(response => {
      const courses = response.json();
      return courses.map((course) => new Course(course));
    })
    .catch(this.handleError);
  }
  
  // API: GET /api/professor
  public getAllProfessors(){
      return this.http
    .get(API_URL + '/api/professor')
    .map(response => {
      const professors = response.json();
      return professors.map((professor) => new Professor(professor));
    })
    .catch(this.handleError);
   }
    
  // API: POST /api/courses
  public createCourse(course: Course) {
    return this.http
    .post(API_URL + '/api/course',JSON.stringify(course), {headers: this.getHeaders()})
    .map(response => response.json().data)
    .catch(this.handleError);
  }
    
   public makeFileRequest ( params: string[], files: File[]): Observable<string> {
        let url = API_URL + '/api/upload';
        var headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        let formData = new FormData();
        if (files.length > 0) { // a file was selected
                formData.append('file', files[0]);
            return this.http
                .post(url, formData,{
                    headers: headers
                  })
                .map((response: Response) => response.text())
            }
  }

    
  private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}