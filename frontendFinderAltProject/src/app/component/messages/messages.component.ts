import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface Message {
  from: 'user' | 'company';
  content: string;
  timestamp: Date;
}

interface Conversation {
  companyName: string;
  companyId: number;
  messages: Message[];
}

@Component({
  selector: 'app-messages',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent {
  conversations: Conversation[] = [
    {
      companyId: 1,
      companyName: 'OpenTech',
      messages: [
        { from: 'company', content: 'Bonjour, intéressé par un entretien ?', timestamp: new Date() },
        { from: 'user', content: 'Bonjour, oui avec plaisir !', timestamp: new Date() }
      ]
    },
    {
      companyId: 2,
      companyName: 'DataPlus',
      messages: [
        { from: 'company', content: 'On a vu ton profil, très intéressant.', timestamp: new Date() }
      ]
    }
  ];

  selectedConversation: Conversation | null = null;
  newMessage: string = '';

  openConversation(conv: Conversation) {
    this.selectedConversation = conv;
  }

  sendMessage() {
    if (this.newMessage.trim() && this.selectedConversation) {
      this.selectedConversation.messages.push({
        from: 'user',
        content: this.newMessage,
        timestamp: new Date()
      });
      this.newMessage = '';
    }
  }

  backToList() {
    this.selectedConversation = null;
  }
}
