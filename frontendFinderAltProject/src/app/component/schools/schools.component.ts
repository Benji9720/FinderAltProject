// schools.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-schools',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './schools.component.html',
  styleUrls: ['./schools.component.css']
})
export class SchoolsComponent {
  school = {
    name: 'Lycée Henri IV',
    address: '23 Rue Clovis, 75005 Paris',
    contact: 'contact@lyceeh4.fr',
    phone: '+33 1 23 45 67 89',
    description: `Lycée d'excellence proposant un accompagnement personnalisé pour les alternants.`
  };

  constructor(private router: Router) {}

  goToMessageSchool() {
    this.router.navigate(['/messageschools']);
  }

  togglePlanning() {
    this.router.navigate(['/planning']);
    // Logique d'affichage du planning (composant séparé)
  }
}
