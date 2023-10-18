import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarCompnentBackComponent } from './navbar-compnent-back.component';

describe('NavbarCompnentBackComponent', () => {
  let component: NavbarCompnentBackComponent;
  let fixture: ComponentFixture<NavbarCompnentBackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarCompnentBackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarCompnentBackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
