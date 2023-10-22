import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FootbarComponentComponent } from './footbar-component.component';

describe('FootbarComponentComponent', () => {
  let component: FootbarComponentComponent;
  let fixture: ComponentFixture<FootbarComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FootbarComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FootbarComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
