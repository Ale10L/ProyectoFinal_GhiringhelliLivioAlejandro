import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-redessociales',
  templateUrl: './redessociales.component.html',
  styleUrls: ['./redessociales.component.css']
})
export class RedessocialesComponent implements OnInit {
  persona: Persona = new Persona("", "", "", "", "", "", "", "", "", "", "", "");
  constructor(public personaService: PersonaService, private router: Router) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data});
  }

  login(){
    this.router.navigate(['/login']);
  }
}
