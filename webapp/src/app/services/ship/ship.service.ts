import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Armor, IShip, Rarity } from '../../entities/ship.model';


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
export class ShipService {
  private apiUrl = 'http://localhost:8080/api/ship';

  constructor(private http: HttpClient,) {}

  getship(params: {
    page: number;
    size: number;
    sort: string;
    name?: string | null;
    fraction?: string | null;
    classification?: string | null;
    armor ?: Armor | null;
    rarity?: Rarity | null;
  }): Observable<PageResponse<IShip>> {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString())
      .set('sort', params.sort);

    if (params.name) {
      httpParams = httpParams.set('name.startsWith', params.name);
    }
    if (params.fraction) {
      httpParams = httpParams.set('fractionIndex', params.fraction);
    }
    if (params.classification) {
      httpParams = httpParams.set('classificationIndex', params.classification);
    }
    if (params.armor) {
      httpParams = httpParams.set('armor', params.armor);
    }
    if (params.rarity) {
      httpParams = httpParams.set('rarity', params.rarity);
    }

    return this.http.get<PageResponse<IShip>>(this.apiUrl, { params: httpParams });
  }

  deleteShip(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
  }

  getShipById(id: number): Observable<IShip> {
  return this.http.get<IShip>(`${this.apiUrl}/${id}`);
}
}