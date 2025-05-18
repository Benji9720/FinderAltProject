import { Injectable } from "@angular/core";

interface LoginUser {
  id: number;
  email: string;
  fullName: string;
  role: string;
  password: string;
}

@Injectable({ providedIn: "root" })
export class AuthService {
  private users: LoginUser[] = [
    { id: 1, email: "etudiant@test.com", fullName: "Alice Étudiante", role: "Alternant", password: "etudiant123" },
    { id: 2, email: "entreprise@test.com", fullName: "Bob Entreprise", role: "Entreprise", password: "entreprise123" },
    { id: 3, email: "ecole@test.com", fullName: "Claire École", role: "École", password: "ecole123" }
  ];

  login(email: string, password: string): boolean {
    const user = this.users.find(u => u.email === email && u.password === password);
    if (user) {
      const { password, ...userData } = user;
      localStorage.setItem("user", JSON.stringify(userData));
      return true;
    }
    return false;
  }

  logout(): void {
    localStorage.removeItem("user");
  }

  getCurrentUser(): Omit<LoginUser, "password"> | null {
    const user = localStorage.getItem("user");
    return user ? JSON.parse(user) : null;
  }
}
