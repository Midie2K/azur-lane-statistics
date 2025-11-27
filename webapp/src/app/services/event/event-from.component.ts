import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';
import { IEvent } from '../../entities/event.model';

@Component({
  selector: 'event-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './event-form.component.html',
})
export class EventFormComponent implements OnInit {
  form!: FormGroup;
  events?: IEvent;
  private apiUrl = 'http://localhost:8080/api/event';

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.form = this.fb.group({
      id : null,
      name: [''],
    });

    const id = this.route.snapshot.queryParamMap.get('id');
    if (id) {
      this.http.get<IEvent>(`${this.apiUrl}/${id}`).subscribe(data => {
        this.events = data;
        this.form.patchValue({
          id: data.id || null,
          name: data.name || ''
        });
      });
    }
  }

  submit() {
    const data: IEvent = this.form.getRawValue();

    if (this.events?.id) {
      this.http.put<IEvent>(this.apiUrl, data).subscribe(res => {
        this.router.navigate(['/event']);
      });
    } else {
      this.http.post<IEvent>(this.apiUrl, data).subscribe(res => {
        this.router.navigate(['/event']);
      });
    }
  }
}