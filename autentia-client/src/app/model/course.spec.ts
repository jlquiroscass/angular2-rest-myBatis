import {Course} from './course.entity';

describe('Course', () => {
  it('should create an instance', () => {
    expect(new Course()).toBeTruthy();
  });
    
  it('should accept values in the constructor', () => {
    let course = new Course({
      name: 'java 101',
      numHours:25
    });
    expect(course.name).toEqual('java 101');
    expect(course.numHours).toEqual(25);
  });
});