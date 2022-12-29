import { TestBed } from '@angular/core/testing';

import { ClaimsRegistrationService } from './claims-registration.service';

describe('ClaimsRegistrationService', () => {
  let service: ClaimsRegistrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClaimsRegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
