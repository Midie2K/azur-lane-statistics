import { Routes } from '@angular/router';
import { ClassificationComponent } from './services/classification/classification.component';
import { ClassificationFormComponent } from './services/classification/classification-form.component';

export const routes: Routes = [
     { path: '', redirectTo: 'classification', pathMatch: 'full' },
  { path: 'classification', component: ClassificationComponent },
  { path: 'classification-form', component: ClassificationFormComponent },
];
