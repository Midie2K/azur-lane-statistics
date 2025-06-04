import { Routes } from '@angular/router';
import { ClassificationComponent } from './services/classification/classification.component';
export const routes: Routes = [
     { path: '', redirectTo: 'classification', pathMatch: 'full' },
  { path: 'classification', component: ClassificationComponent },
];
