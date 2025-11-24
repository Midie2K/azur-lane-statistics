import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { IClassification } from '../../entities/classification.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'classification-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  templateUrl: './classification-form.component.html',
})
export class ClassificationFormComponent implements OnInit {
  form!: FormGroup;
  private apiUrl = 'http://localhost:8080/api/classification';

  private _classification?: IClassification;

  @Input()
  set classification(value: IClassification | undefined) {
    this._classification = value;
    if (value && this.form) {
      this.form.patchValue(value);
    }
  }

  get classification(): IClassification | undefined {
    return this._classification;
  }

  @Output() submitted = new EventEmitter<IClassification>();

  constructor(private fb: FormBuilder, private http: HttpClient) {}

  ngOnInit() {
    this.form = this.fb.group({
      index: [''],
      name: [''],
    });

    // Patch initial value jeśli już jest Input ustawiony przed ngOnInit
    if (this._classification) {
      this.form.patchValue(this._classification);
    }
  }

  submit() {
    const data: IClassification = this.form.getRawValue();

    if (this._classification?.id) {
      // Edycja - PUT
      this.updateClassification(this._classification.id, data).subscribe(res => {
        this.submitted.emit(res);
        this.form.reset();
      });
    } else {
      // Dodawanie - POST
      this.createClassification(data).subscribe(res => {
        this.submitted.emit(res);
        this.form.reset();
      });
    }
  }

  private createClassification(classification: IClassification): Observable<IClassification> {
    return this.http.post<IClassification>(this.apiUrl, classification);
  }

  private updateClassification(id: number, classification: IClassification): Observable<IClassification> {
    return this.http.put<IClassification>(`${this.apiUrl}/${id}`, classification);
  }
}
