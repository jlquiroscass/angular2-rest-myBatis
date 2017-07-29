import {Professor} from './professor.entity';

describe('Professor', () => {
  it('should create an instance', () => {
    expect(new Professor()).toBeTruthy();
  });
    
  it('should accept values in the constructor', () => {
    let professor = new Professor({
      first_name: 'John',
      last_name:'Snow'
    });
    expect(professor.first_name).toEqual('John');
    expect(professor.last_name).toEqual('Snow');
  });
});