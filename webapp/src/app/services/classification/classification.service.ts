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

  getClassifications(params: {
    page: number;
    size: number;
    sort: string;
    index?: string | null;
    name?: string | null;
  }): Observable<PageResponse<IClassification>> {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString())
      .set('sort', params.sort);

    // Dodajemy filtry tylko jeśli są obecne i niepuste
    if (params.index) {
      httpParams = httpParams.set('index.startsWith', params.index);
    }

    if (params.name) {
      httpParams = httpParams.set('name.startsWith', params.name);
    }

    return this.http.get<PageResponse<IClassification>>(this.apiUrl, { params: httpParams });
  }
}
