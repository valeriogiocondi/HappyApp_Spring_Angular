import { TestBed, inject } from '@angular/core/testing';

import { DeleteQuestionService } from './delete-question.service';

describe('DeleteQuestionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DeleteQuestionService]
    });
  });

  it('should be created', inject([DeleteQuestionService], (service: DeleteQuestionService) => {
    expect(service).toBeTruthy();
  }));
});
