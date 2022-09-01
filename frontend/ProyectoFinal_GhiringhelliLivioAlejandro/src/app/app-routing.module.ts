import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NuevaExperienciaComponent } from './componentes/experiencia/nueva-experiencia.component';
import { HomeComponent } from './componentes/home/home.component';
import { LoginComponent } from './componentes/login/login.component';
//import { PersonaGuardService } from './guards/persona-guard.service';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  //{path: 'crearexp', component: NuevaExperienciaComponent, canActivate: [PersonaGuardService], data: { expectedRol: ['admin'] } },
  {path: 'crearexp', component: NuevaExperienciaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
