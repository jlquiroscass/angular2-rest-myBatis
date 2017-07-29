export class Professor {
  id: number
  first_name: string
  last_name: string
    
   constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}