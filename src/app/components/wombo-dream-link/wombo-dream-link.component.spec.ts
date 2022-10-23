import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WomboDreamLinkComponent } from './wombo-dream-link.component';

describe('WomboDreamLinkComponent', () => {
  let component: WomboDreamLinkComponent;
  let fixture: ComponentFixture<WomboDreamLinkComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WomboDreamLinkComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WomboDreamLinkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
