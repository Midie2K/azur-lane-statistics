import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IClassification } from '../../entities/classification.model';

interface PageResponse<T> {
  content: T[];
  last: boolean;
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
}

@Injectable({
  providedIn: 'root'
})
export class ClassificationService {
  private apiUrl = 'http://localhost:8080/api/classification';

  constructor(private http: HttpClient) {}

  getClassifications(params: { page: number; size: number; sort: string }): Observable<PageResponse<IClassification>> {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString())
      .set('sort', params.sort);

    return this.http.get<PageResponse<IClassification>>(this.apiUrl, { params: httpParams });
  }
}
