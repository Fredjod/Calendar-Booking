import { TestBed } from '@angular/core/testing';

import { DataPlanningService } from './data-planning.service';

describe('DataPlanningService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DataPlanningService = TestBed.get(DataPlanningService);
    expect(service).toBeTruthy();
  });
});
