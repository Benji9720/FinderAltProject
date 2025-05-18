// planning.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-planning',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.css']
})
export class PlanningComponent {
  schedule = [
    { day: 'Lundi', event: 'Cours de Java', time: '09:00 - 12:00' },
    { day: 'Mardi', event: 'Projet Angular', time: '14:00 - 17:00' },
    { day: 'Mercredi', event: 'Libre', time: '-' },
    { day: 'Jeudi', event: 'Atelier CV / Entretien', time: '10:00 - 12:00' },
    { day: 'Vendredi', event: 'Cours de Base de données', time: '08:30 - 11:30' }
  ];
}
