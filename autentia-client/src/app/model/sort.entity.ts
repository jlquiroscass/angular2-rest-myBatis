export class SortForm {
     columnName: string;
     ascDesc : string;
    
   constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}