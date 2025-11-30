import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { HttpClient,  } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule, Router, ActivatedRoute } from '@angular/router';
import { IShipClass } from '../../entities/shipClass.model';

@Component({
  selector: 'classification-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './shipclass-form.component.html',
})
export class ShipClassFormComponent implements OnInit {
  form!: FormGroup;
  shipclases?: IShipClass;
  private apiUrl = 'http://localhost:8080/api/ship-class';

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
      this.http.get<IShipClass>(`${this.apiUrl}/${id}`).subscribe(data => {
        this.shipclases = data;
        this.form.patchValue({
          id: data.id || null,
          name: data.name || ''
        });
      });
    }
  }

  submit() {
    const data: IShipClass = this.form.getRawValue();

    if (this.shipclases?.id) {
      this.http.put<IShipClass>(this.apiUrl, data).subscribe(res => {
        this.router.navigate(['/shipclass']);
      });
    } else {
      this.http.post<IShipClass>(this.apiUrl, data).subscribe(res => {
        this.router.navigate(['/shipclass']);
      });
    }
  }
}