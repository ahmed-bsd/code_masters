import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarCompnentBackComponent } from './sidebar-compnent-back.component';

describe('SidebarCompnentBackComponent', () => {
  let component: SidebarCompnentBackComponent;
  let fixture: ComponentFixture<SidebarCompnentBackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidebarCompnentBackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarCompnentBackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
