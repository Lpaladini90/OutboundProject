import { TestBed } from '@angular/core/testing';

import { GearlistsService } from './gearlists.service';

describe('GearlistsService', () => {
  let service: GearlistsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GearlistsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
