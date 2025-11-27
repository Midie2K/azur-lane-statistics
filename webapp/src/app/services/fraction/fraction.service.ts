import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IFraction } from '../../entities/fraction.model';

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
export class FractionService {
  private apiUrl = 'http://localhost:8080/api/fraction';

  constructor(private http: HttpClient) {}

  getFractions(params: {
    page: number;
    size: number;
    sort: string;
    index?: string | null;
    name?: string | null;
  }): Observable<PageResponse<IFraction>> {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString())
      .set('sort', params.sort);

    if (params.index) {
      httpParams = httpParams.set('index.startsWith', params.index);
    }

    if (params.name) {
      httpParams = httpParams.set('name.startsWith', params.name);
    }

    return this.http.get<PageResponse<IFraction>>(this.apiUrl, { params: httpParams });
  }

  deleteFraction(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
