// messageschools.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-messageschools',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './messageschools.component.html',
  styleUrls: ['./messageschools.component.css']
})
export class MessageSchoolsComponent {
  messages: { from: 'user' | 'school'; content: string; timestamp: Date }[] = [
    { from: 'school', content: "Bonjour, n'hésitez pas à poser vos questions !", timestamp: new Date() }
  ];

  newMessage = '';

  sendMessage() {
    if (this.newMessage.trim()) {
      this.messages.push({
        from: 'user',
        content: this.newMessage,
        timestamp: new Date()
      });
      this.newMessage = '';
    }
  }
}
