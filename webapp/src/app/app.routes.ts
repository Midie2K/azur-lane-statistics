import { Routes } from '@angular/router';
import { ClassificationComponent } from './services/classification/classification.component';
import { ClassificationFormComponent } from './services/classification/classification-form.component';
import { ShipClassFormComponent } from './services/shipClass/shipclass-form.component';
import { EventComponent } from './services/event/event.component';
import { EventFormComponent } from './services/event/event-from.component';
import { ShipclassComponent } from './services/shipClass/shipclass.component';
import { FractionComponent } from './services/fraction/fraction.component';
import { FractionFormComponent } from './services/fraction/fraction-form.component';

export const routes: Routes = [
     { path: '', redirectTo: 'classification', pathMatch: 'full' },
  { path: 'classification', component: ClassificationComponent },
  { path: 'classification-form', component: ClassificationFormComponent },

  { path: 'shipclass', component: ShipclassComponent },
  { path: 'shipclass-form', component: ShipClassFormComponent },

  { path: 'event', component: EventComponent },
  { path: 'event-form', component: EventFormComponent },

  { path: 'fraction', component: FractionComponent },
  { path: 'fraction-form', component: FractionFormComponent },

];
