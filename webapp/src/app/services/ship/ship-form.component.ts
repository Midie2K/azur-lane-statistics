import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Armor, IShip, Rarity } from '../../entities/ship.model';
import { FractionService } from '../fraction/fraction.service';
import { ClassificationService } from '../classification/classification.service';
import { ShipClassService } from '../shipClass/shipclass.service';
import { EventService } from '../event/event.service';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ShipService } from './ship.service';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-ship-form',
  templateUrl: './ship-form.component.html',
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterModule],
})
export class ShipFormComponent implements OnInit {
  @Output() saveSuccess = new EventEmitter<boolean>();

    private apiUrl = 'http://localhost:8080/api/ship';

  editForm!: FormGroup;
  isSaving = false;

  ship?: IShip;

  fractions$ = new BehaviorSubject<any[]>([]);
    classifications$ = new BehaviorSubject<any[]>([]);
    shipClasses$ = new BehaviorSubject<any[]>([]);
    events$ = new BehaviorSubject<any[]>([]);

  armorOptions: string[] = [];
  rarityOptions: string[] = [];

  fractionSearch: string = '';
  classificationSearch: string = '';
  shipClassSearch: string = '';
  eventSearch: string = '';

  constructor(
    private fb: FormBuilder,
    private fractionService: FractionService,
    private classificationService: ClassificationService,
    private shipClassService: ShipClassService,
    private eventService: EventService,
    private shipService: ShipService,
    private router: Router,
    private route: ActivatedRoute,
    private http: HttpClient
  ) {
    this.createForm();
  }

  ngOnInit(): void {
    // Enum options
    this.armorOptions = Object.values(Armor);
    this.rarityOptions = Object.values(Rarity);

    this.createForm();

    // Load ship if editing
    const id = this.route.snapshot.queryParamMap.get('id');
    if (id) {
      this.shipService.getShipById(+id).subscribe(ship => {
        this.editForm.patchValue({
          id: ship.id || null,
          name: ship.name || '',
          fractionId: ship.fractionId || null,
          classificationId: ship.classificationId || null,
          shipClassId: ship.shipClassId || null,
          eventId: ship.eventId || null,
          hp: ship.hp || null,
          fp: ship.fp || null,
          trp: ship.trp || null,
          avi: ship.avi || null,
          aa: ship.aa || null,
          rld: ship.rld || null,
          evi: ship.evi || null,
          spd: ship.spd || null,
          acc: ship.acc || null,
          lck: ship.lck || null,
          asw: ship.asw || null,
          armor: ship.armor || null,
          rarity: ship.rarity || null,
          buildTime: ship.buildTime || null,
          avatar: ship.avatar || null
        });
      });
    }
  }

  createForm(): void {
    this.editForm = this.fb.group({
      id: [null],
      name: [''],
      fractionId: [null],
      classificationId: [null],
      shipClassId: [null],
      eventId: [null],
      hp: [null],
      fp: [null],
      trp: [null],
      avi: [null],
      aa: [null],
      rld: [null],
      evi: [null],
      spd: [null],
      acc: [null],
      lck: [null],
      asw: [null],
      armor: [null],
      rarity: [null],
      buildTime: [''],
      avatar: ['']
    });
  }

  save(): void {
    this.isSaving = true;
    this.submit( this.createFromForm());
    setTimeout(() => {
      this.isSaving = false;
      this.saveSuccess.emit(true);
    }, 500);
  }

  submit(ship: IShip) {
      const data: IShip = ship;
  
      if (data.id) {
        this.http.put<IShip>(this.apiUrl, data).subscribe(res => {
          this.router.navigate(['/ship']);
        });
      } else {
        this.http.post<IShip>(this.apiUrl, data).subscribe(res => {
          this.router.navigate(['/ship']);
        });
      }
    }

  private createFromForm(): IShip {
    const raw = this.editForm.getRawValue();
    return {
      id: raw.id,
      name: raw.name,
      fractionId: raw.fractionId,
      classificationId: raw.classificationId,
      shipClassId: raw.shipClassId,
      eventId: raw.eventId,
      hp: raw.hp,
      fp: raw.fp,
      trp: raw.trp,
      avi: raw.avi,
      aa: raw.aa,
      rld: raw.rld,
      evi: raw.evi,
      spd: raw.spd,
      acc: raw.acc,
      lck: raw.lck,
      asw: raw.asw,
      armor: raw.armor,
      rarity: raw.rarity,
      buildTime: this.parseTimeToSeconds(raw.buildTime),
      avatar: raw.avatar
    };
  }

  parseTimeToSeconds(time: string): number {
    if (!time) return 0;
    const parts = time.split(':').map(p => parseInt(p, 10));
    if (parts.length === 1) return parts[0];
    if (parts.length === 2) return parts[0] * 60 + parts[1];
    if (parts.length === 3) return parts[0] * 3600 + parts[1] * 60 + parts[2];
    return 0;
  }

  loadFractions(search?: string): void {
    this.fractionService
        .getFractions({ page: 0, size: 10, sort: 'id,asc', name: search || null })
        .subscribe(res => {
            const list = Array.isArray(res) ? res : (res.content ?? []);
            this.fractions$.next(list); // aktualizacja BehaviorSubject
        });
    }

    loadClassifications(search?: string): void {
    this.classificationService
        .getClassifications({ page: 0, size: 10, sort: 'id,asc', index: search || null })
        .subscribe(res => {
            const list = Array.isArray(res) ? res : (res.content ?? []);
            this.classifications$.next(list);
        });
    }

    loadShipClasses(search?: string): void {
    this.shipClassService
        .getshipclass({ page: 0, size: 10, sort: 'id,asc', name: search || null })
        .subscribe(res => {
            const list = Array.isArray(res) ? res : (res.content ?? []);
            this.shipClasses$.next(list);
        });
    }

    loadEvents(search?: string): void {
    this.eventService
        .getevent({ page: 0, size: 10, sort: 'id,asc', name: search || null })
        .subscribe(res => {
            const list = Array.isArray(res) ? res : (res.content ?? []);
            this.events$.next(list);
        });
    }
}
