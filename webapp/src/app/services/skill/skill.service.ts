import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ISkill } from "../../entities/skill.model";
import { Observable } from 'rxjs';


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
export class SkillService {
  private apiUrl = 'http://localhost:8080/api/skill';

  constructor(private http: HttpClient) {}

  getSkills(params: {
    page: number;
    size: number;
    sort: string;
    ship_id: number;
  }): Observable<PageResponse<ISkill>> {
    let httpParams = new HttpParams()
      .set('page', params.page.toString())
      .set('size', params.size.toString())
      .set('sort', params.sort);

    if (params.ship_id) {
      httpParams = httpParams.set('ship_id', params.ship_id);
    }

    return this.http.get<PageResponse<ISkill>>(this.apiUrl, { params: httpParams });
  }

  getSkillsByShipId(id?: number){
    return this.http.get<ISkill[]>(`${this.apiUrl}/${id}`);
  }

  deleteSkill(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
  }
}