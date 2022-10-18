import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonacardComponent } from './personacard.component';

describe('PersonacardComponent', () => {
  let component: PersonacardComponent;
  let fixture: ComponentFixture<PersonacardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonacardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PersonacardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
