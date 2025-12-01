import { Component, OnInit, ChangeDetectorRef, Inject, PLATFORM_ID, AfterViewInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Armor, IShip, Rarity } from '../../entities/ship.model';
import { ShipService } from './ship.service';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-ship',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  styleUrls: ['./ship.component.css'],
  templateUrl: './ship.component.html'
})
export class ShipComponent implements OnInit, AfterViewInit {
  ships: IShip[] = [];
  armorOptions: string[] = [];
  rarityOptions: string[] = [];
  currentPage = 0;
  pageSize = 10;
  totalPages = 0;
  hasNextPage = false;
  pageSizes = [10, 25, 50];
  loading = false;

  sortField = 'id';
  sortDirection: 'asc' | 'desc' = 'asc';

  filters = {
    name: '',
    fraction: '',
    classification: '',
    armor: null,
    rarity: null
  };

  constructor(
    private shipService: ShipService,
    private cd: ChangeDetectorRef,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  ngOnInit(): void {
    this.loadShip();
    this.armorOptions = Object.values(Armor);
    this.rarityOptions = Object.values(Rarity);
  }

  loadShip(): void {
    this.loading = true;

    const params = {
      page: this.currentPage,
      size: this.pageSize,
      sort: `${this.sortField},${this.sortDirection}`,
      name: this.filters.name || null
    };

    this.shipService.getship(params).subscribe({
      next: (res) => {
        this.ships = res.content;
        this.totalPages = res.totalPages;
        this.hasNextPage = !res.last;
        this.cd.detectChanges();
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  changePageSize(event: Event): void {
    const value = +(event.target as HTMLSelectElement).value;
    this.pageSize = value;
    this.currentPage = 0;
    this.loadShip();
  }

  changePage(page: number): void {
    if (page >= 0 && page < this.totalPages) {
      this.currentPage = page;
      this.loadShip();
    }
  }

  sortBy(field: string): void {
    if (this.sortField === field) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortField = field;
      this.sortDirection = 'asc';
    }
    this.loadShip();
  }

  applyFilters(): void {
    this.currentPage = 0;
    this.loadShip();
  }

  onDelete(id: number) {
    if (!confirm("Are you sure you want to delete this item?")) {
      return;
    }

    this.shipService.deleteShip(id).subscribe({
      next: () => {
        this.loadShip();
      },
      error: err => {
        alert("Failed to delete item.");
      }
    });
  }

  async ngAfterViewInit() {
    if (!isPlatformBrowser(this.platformId)) return;

    const Tooltip = (await import('bootstrap/js/dist/tooltip')).default;

    const elements = document.querySelectorAll('[data-bs-toggle="tooltip"]') as NodeListOf<HTMLElement>;
    elements.forEach(el => new Tooltip(el));
  }

  formatTime(seconds?: number | string): string {
    if (seconds == null) return '';

    if (seconds == 0) return 'DROP / EXCHANGE';

    const totalSeconds = Number(seconds);
    if (isNaN(totalSeconds)) return '';

    const h = Math.floor(totalSeconds / 3600);
    const m = Math.floor((totalSeconds % 3600) / 60);
    const s = totalSeconds % 60;
    return `${h}:${m.toString().padStart(2,'0')}:${s.toString().padStart(2,'0')}`;
    }

    getRarityClass(rarity?: Rarity): string {
    switch(rarity) {
        case Rarity.COMMON: return 'rarity-common';
        case Rarity.RARE: return 'rarity-rare';
        case Rarity.ELITE: return 'rarity-elite';
        case Rarity.SUPER_RARE: return 'rarity-super_rare';
        case Rarity.ULTRA_RARE: return 'rarity-ultra_rare';
        default: return '';
        }
    }
}
