import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormsAnnonceComponent } from './forms-annonce.component';

describe('FormsAnnonceComponent', () => {
  let component: FormsAnnonceComponent;
  let fixture: ComponentFixture<FormsAnnonceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormsAnnonceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormsAnnonceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
