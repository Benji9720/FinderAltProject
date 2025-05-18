import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageschoolsComponent } from './messageschools.component';

describe('MessageschoolsComponent', () => {
  let component: MessageschoolsComponent;
  let fixture: ComponentFixture<MessageschoolsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MessageschoolsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MessageschoolsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
