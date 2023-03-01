import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { EditPlayerComponent } from './edit-player/edit-player.component';
import { StartComponent } from './start/start.component';
import { VergleichComponent } from './vergleich/vergleich.component';

const routes: Routes = [
  {path: '', component: StartComponent},
  {path: 'start', component: StartComponent},
  {path: 'vergleich', component: VergleichComponent},
  {path: 'editPlayer/:mode', component: EditPlayerComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    RouterModule,
    RouterTestingModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  exports: [RouterModule]
})
export class AppRoutingModule { }
