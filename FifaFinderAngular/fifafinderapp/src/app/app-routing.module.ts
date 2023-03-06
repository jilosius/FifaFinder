import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { EditPlayerComponent } from './edit-player/edit-player.component';
import { HomeComponent } from './home/home.component';
import { PlayerComponent } from './player/player.component';
import { StartComponent } from './start/start.component';
import { VergleichComponent } from './vergleich/vergleich.component';

const routes: Routes = [
  {path: '', component: StartComponent},
  {path: 'start', component: StartComponent},
  {path: 'vergleich', component: VergleichComponent},
  {path:'HomeComponent',component:HomeComponent,},
  {path:"PlayerComponent",component:PlayerComponent},
  {path:"StartComponent",component:StartComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'editPlayer/:mode/:playerId/:fifaVersion', component: EditPlayerComponent}
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
