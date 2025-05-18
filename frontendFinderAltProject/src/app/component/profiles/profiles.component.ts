// profiles.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-profiles',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent {
  nom = 'Jean Dupont';
  email = 'jean.dupont@example.com';
  role = 'Alternant';
  bio = 'Étudiant en informatique passionné par le développement web et les nouvelles technologies.';

  editMode = false;

  toggleEdit(): void {
    this.editMode = !this.editMode;
  }

  saveProfile(): void {
    this.editMode = false;
    // ici on pourrait appeler un service pour sauvegarder
  }
}
