import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IShipClass } from '../../entities/shipClass.model';

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
export class ShipClassService {
  private apiUrl = 'http://localhost:8080/api/ship-class';

  constructor(private http: HttpClient) {}

  getshipclass(params: {
    page: number;
    size: number;
    sort: string;
    index?: string | null;
    name?: string | null;
  }): Observable<PageResponse<IShipClass>> {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString())
      .set('sort', params.sort);

    if (params.name) {
      httpParams = httpParams.set('name.startsWith', params.name);
    }

    return this.http.get<PageResponse<IShipClass>>(this.apiUrl, { params: httpParams });
  }

  deleteShipclass(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
  }
}