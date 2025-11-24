import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { IClassification } from '../../entities/classification.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'classification-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule, RouterModule],
  templateUrl: './classification-form.component.html',
})
export class ClassificationFormComponent implements OnInit {
  form!: FormGroup;
  classification?: IClassification;
  private apiUrl = 'http://localhost:8080/api/classification';

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.form = this.fb.group({
      index: [''],
      name: [''],
    });

    const id = this.route.snapshot.queryParamMap.get('id');
    if (id) {
      this.http.get<IClassification>(`${this.apiUrl}/${id}`).subscribe(data => {
        this.classification = data;
        this.form.patchValue({
          index: data.index || '',
          name: data.name || ''
        });
      });
    }
  }

  submit() {
    const data: IClassification = this.form.getRawValue();

    if (this.classification?.id) {
      this.http.put<IClassification>(`${this.apiUrl}/${this.classification.id}`, data).subscribe(res => {
        alert('Classification updated!');
        this.router.navigate(['/classification']);
      });
    } else {
      this.http.post<IClassification>(this.apiUrl, data).subscribe(res => {
        alert('Classification added!');
        this.router.navigate(['/classification']);
      });
    }
  }
}
