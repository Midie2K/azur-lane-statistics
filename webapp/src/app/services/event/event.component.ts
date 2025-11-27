import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { IEvent } from '../../entities/event.model';
import { EventService } from './event.service';

@Component({
  selector: 'app-event',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './event.component.html'
})
export class EventComponent implements OnInit {
  events: IEvent[] = [];
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
    private eventService: EventService,
    private cd: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadevent();
  }

loadevent(): void {
  this.loading = true;

  const params = {
    page: this.currentPage,
    size: this.pageSize,
    sort: `${this.sortField},${this.sortDirection}`,
    name: this.filters.name || null
  };

  this.eventService.getevent(params).subscribe({
    next: (res) => {
      this.events = res.content;
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
    this.loadevent();
  }

  changePage(page: number): void {
    if (page >= 0 && page < this.totalPages) {
      this.currentPage = page;
      this.loadevent();
    }
  }

  sortBy(field: string): void {
    if (this.sortField === field) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortField = field;
      this.sortDirection = 'asc';
    }
    this.loadevent();
  }

  applyFilters(): void {
    this.currentPage = 0;
    this.loadevent();
  }

  onDelete(id: number) {
  if (!confirm("Are you sure you want to delete this item?")) {
    return;
  }

    this.eventService.deleteEvent(id).subscribe({
      next: () => {
        this.loadevent();
      },
      error: err => {
        console.error("Delete error:", err);
        alert("Failed to delete item.");
      }
    });
  }
}