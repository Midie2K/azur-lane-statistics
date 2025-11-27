import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { IShipClass } from '../../entities/shipClass.model';
import { ShipClassService } from './shipclass.service';

@Component({
  selector: 'app-shipclass',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './shipclass.component.html'
})
export class ShipclassComponent implements OnInit {
  shipclasses: IShipClass[] = [];
  currentPage = 0;
  pageSize = 10;
  totalPages = 0;
  hasNextPage = false;
  pageSizes = [10, 25, 50];
  loading = false;

  sortField = 'id';
  sortDirection: 'asc' | 'desc' = 'asc';

  filters = {
    name: ''
  };

  constructor(
    private shipclassService: ShipClassService,
    private cd: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadShipclass();
  }

loadShipclass(): void {
  this.loading = true;

  const params = {
    page: this.currentPage,
    size: this.pageSize,
    sort: `${this.sortField},${this.sortDirection}`,
    name: this.filters.name || null
  };

  this.shipclassService.getshipclass(params).subscribe({
    next: (res) => {
      this.shipclasses = res.content;
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
    this.loadShipclass();
  }

  changePage(page: number): void {
    if (page >= 0 && page < this.totalPages) {
      this.currentPage = page;
      this.loadShipclass();
    }
  }

  sortBy(field: string): void {
    if (this.sortField === field) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortField = field;
      this.sortDirection = 'asc';
    }
    this.loadShipclass();
  }

  applyFilters(): void {
    this.currentPage = 0;
    this.loadShipclass();
  }

  onDelete(id: number) {
  if (!confirm("Are you sure you want to delete this item?")) {
    return;
  }

    this.shipclassService.deleteShipclass(id).subscribe({
      next: () => {
        this.loadShipclass();
      },
      error: err => {
        console.error("Delete error:", err);
        alert("Failed to delete item.");
      }
    });
  }
}