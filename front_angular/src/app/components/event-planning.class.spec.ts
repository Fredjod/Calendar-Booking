import { TestBed } from '@angular/core/testing';

import { EventPlanningClass } from './event-planning.class';

describe('EventPlanningClass', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EventPlanningClass = TestBed.get(EventPlanningClass);
    expect(service).toBeTruthy();
  });
});
