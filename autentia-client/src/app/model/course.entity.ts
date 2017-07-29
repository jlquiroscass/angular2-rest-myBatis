import { Professor } from './professor.entity';

export class Course {
  id: number
  name: string
  active: boolean
  numHours:number
  level:string
  professor:Professor
    
   constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}