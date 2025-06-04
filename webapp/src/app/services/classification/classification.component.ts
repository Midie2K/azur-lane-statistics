import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClassificationService } from './classification.service';
import { IClassification } from '../../entities/classification.model';

@Component({
  selector: 'app-classification',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './classification.component.html'
})
export class ClassificationComponent implements OnInit {
  classifications: IClassification[] = [];
  currentPage = 0;
  pageSize = 10;
  totalPages = 0;
  hasNextPage = false;
  pageSizes = [10, 25, 50];

  sortField = 'id';
  sortDirection: 'asc' | 'desc' = 'asc';

  loading = false;  // można do loadera

  constructor(
    private classificationService: ClassificationService,
    private cd: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadClassifications();
  }

  loadClassifications(): void {
    this.loading = true;

    const params = {
      page: this.currentPage,
      size: this.pageSize,
      sort: `${this.sortField},${this.sortDirection}`
    };

    this.classificationService.getClassifications(params).subscribe({
      next: (res) => {
        this.classifications = res.content;
        this.totalPages = res.totalPages;
        this.hasNextPage = !res.last;
        this.cd.detectChanges();
        this.loading = false;
      },
      error: () => {
        // obsługa błędu
        this.loading = false;
      }
    });
  }

  changePageSize(event: Event): void {
    const value = +(event.target as HTMLSelectElement).value;
    this.pageSize = value;
    this.currentPage = 0;
    this.loadClassifications();
  }

  changePage(page: number): void {
    if (page >= 0 && page < this.totalPages) {
      this.currentPage = page;
      this.loadClassifications();
    }
  }

  sortBy(field: string): void {
    if (this.sortField === field) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortField = field;
      this.sortDirection = 'asc';
    }
    this.loadClassifications();
  }
}
