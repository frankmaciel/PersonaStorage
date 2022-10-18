import { TestBed } from '@angular/core/testing';

import { PersonaDataService } from './persona-data.service';

describe('PersonaDataService', () => {
  let service: PersonaDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersonaDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
