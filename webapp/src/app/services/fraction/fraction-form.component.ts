import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';
import { IFraction } from '../../entities/fraction.model';

@Component({
  selector: 'fraction-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './fraction-form.component.html',
})
export class FractionFormComponent implements OnInit {
  form!: FormGroup;
  fraction?: IFraction;
  private apiUrl = 'http://localhost:8080/api/fraction';

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.form = this.fb.group({
      id : null,
      index: [''],
      name: [''],
    });

    const id = this.route.snapshot.queryParamMap.get('id');
    if (id) {
      this.http.get<IFraction>(`${this.apiUrl}/${id}`).subscribe(data => {
        this.fraction = data;
        this.form.patchValue({
          id: data.id || null,
          index: data.index || '',
          name: data.name || ''
        });
      });
    }
  }

  submit() {
    const data: IFraction = this.form.getRawValue();

    if (this.fraction?.id) {
      this.http.put<IFraction>(this.apiUrl, data).subscribe(res => {
        this.router.navigate(['/fraction']);
      });
    } else {
      this.http.post<IFraction>(this.apiUrl, data).subscribe(res => {
        this.router.navigate(['/fraction']);
      });
    }
  }
}
