import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Armor, IShip, Rarity } from '../../entities/ship.model';
import { Page } from '../../entities/pagination.model';


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

  getship(params: HttpParams) {
  return this.http.get<Page<IShip>>(this.apiUrl, { params });
}

  deleteShip(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
  }

  getShipById(id: number): Observable<IShip> {
  return this.http.get<IShip>(`${this.apiUrl}/${id}`);
}
}