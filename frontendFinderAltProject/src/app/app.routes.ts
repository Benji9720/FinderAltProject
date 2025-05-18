import { Routes } from '@angular/router';
import { NavbarComponent } from './component/navbar/navbar.component';
import { LoginComponent } from './component/login/login.component';
import { MatchComponent } from './component/match/match.component';
import { ProfilesComponent } from './component/profiles/profiles.component';
import { MessagesComponent } from './component/messages/messages.component';
import { SchoolsComponent } from './component/schools/schools.component';
import { MessageSchoolsComponent } from './component/messageschools/messageschools.component';
import {PlanningComponent} from './component/planning/planning.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'match', component: MatchComponent },
  { path: 'profile', component: ProfilesComponent },
  { path: 'messages', component: MessagesComponent },
  { path: 'schools', component: SchoolsComponent },
  { path: 'messageschools', component: MessageSchoolsComponent },
  { path: 'planning', component: PlanningComponent }
];
