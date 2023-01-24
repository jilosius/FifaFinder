import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StartComponent } from './start/start.component';
import { VergleichComponent } from './vergleich/vergleich.component';

const routes: Routes = [
  {path: '', component: StartComponent},
  {path: 'start', component: StartComponent},
  {path: 'vergleich', component: VergleichComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
