import { TestBed } from '@angular/core/testing';

import { BackendIoService } from './backend-io.service';

describe('BackendIoService', () => {
  let service: BackendIoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BackendIoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
