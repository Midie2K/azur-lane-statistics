import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { IFraction } from '../../entities/fraction.model';
import { FractionService } from './fraction.service';

@Component({
  selector: 'app-fraction',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './fraction.component.html'
})
export class FractionComponent implements OnInit {
  fractions: IFraction[] = [];
  currentPage = 0;
  pageSize = 10;
  totalPages = 0;
  hasNextPage = false;
  pageSizes = [10, 25, 50];
  loading = false;

  sortField = 'id';
  sortDirection: 'asc' | 'desc' = 'asc';

  filters = {
    index: '',
    name: ''
  };

  constructor(
    private fractionService: FractionService,
    private cd: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadFractions();
  }

loadFractions(): void {
  this.loading = true;

  const params = {
    page: this.currentPage,
    size: this.pageSize,
    sort: `${this.sortField},${this.sortDirection}`,
    index: this.filters.index || null,
    name: this.filters.name || null
  };

  this.fractionService.getFractions(params).subscribe({
    next: (res) => {
      this.fractions = res.content;
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
    this.loadFractions();
  }

  changePage(page: number): void {
    if (page >= 0 && page < this.totalPages) {
      this.currentPage = page;
      this.loadFractions();
    }
  }

  sortBy(field: string): void {
    if (this.sortField === field) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortField = field;
      this.sortDirection = 'asc';
    }
    this.loadFractions();
  }

  applyFilters(): void {
    this.currentPage = 0;
    this.loadFractions();
  }

  onDelete(id: number) {
  if (!confirm("Are you sure you want to delete this item?")) {
    return;
  }

    this.fractionService.deleteFraction(id).subscribe({
      next: () => {
        this.loadFractions();
      },
      error: err => {
        console.error("Delete error:", err);
        alert("Failed to delete item.");
      }
    });
  }
}
