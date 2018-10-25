import { TestBed, inject } from '@angular/core/testing';

import { GetEmployeesService } from './get-employees.service';

describe('GetEmployeesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetEmployeesService]
    });
  });

  it('should be created', inject([GetEmployeesService], (service: GetEmployeesService) => {
    expect(service).toBeTruthy();
  }));
});
