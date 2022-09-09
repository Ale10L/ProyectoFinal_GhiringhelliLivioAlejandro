import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarExperienciaComponent } from './componentes/experiencia/editar-experiencia.component';
import { ExperienciaComponent } from './componentes/experiencia/experiencia.component';
import { NuevaExperienciaComponent } from './componentes/experiencia/nueva-experiencia.component';
import { HomeComponent } from './componentes/home/home.component';
import { LoginComponent } from './componentes/login/login.component';
//import { PersonaGuardService } from './guards/persona-guard.service';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  //{path: 'crearexp', component: NuevaExperienciaComponent, canActivate: [PersonaGuardService], data: { expectedRol: ['admin'] } },
  //{path: 'explab', component: ExperienciaComponent },
  {path: 'agregarexp', component: NuevaExperienciaComponent},
  {path: 'editarexp/:id', component: EditarExperienciaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
