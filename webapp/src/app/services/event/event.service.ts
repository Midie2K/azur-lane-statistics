import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IShipClass } from '../../entities/shipClass.model';
import { IEvent } from '../../entities/event.model';

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
export class EventService {
  private apiUrl = 'http://localhost:8080/api/event';

  constructor(private http: HttpClient) {}

  getevent(params: {
    page: number;
    size: number;
    sort: string;
    index?: string | null;
    name?: string | null;
  }): Observable<PageResponse<IEvent>> {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString())
      .set('sort', params.sort);

    if (params.name) {
      httpParams = httpParams.set('name.startsWith', params.name);
    }

    return this.http.get<PageResponse<IEvent>>(this.apiUrl, { params: httpParams });
  }

  deleteEvent(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
  }
}