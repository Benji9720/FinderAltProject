// match.component.ts
import {
  Component,
  OnInit,
  ElementRef,
  ViewChild,
  AfterViewInit
} from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

interface Offre {
  id: number;
  titre: string;
  entreprise: string;
  imageUrl?: string;
}

@Component({
  selector: 'app-match',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit, AfterViewInit {
  offres: Offre[] = [];
  currentOffre: Offre | null = null;

  @ViewChild('card') cardRef!: ElementRef;
  private startX = 0;
  private currentX = 0;
  private isDragging = false;
  private readonly SWIPE_THRESHOLD = 100;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.offres = [
      { id: 1, titre: 'Data Analyst', entreprise: 'DataPlus', imageUrl: 'https://picsum.photos/400/300?1' },
      { id: 2, titre: 'Dev Fullstack', entreprise: 'OpenTech', imageUrl: 'https://picsum.photos/400/300?2' },
      { id: 3, titre: 'UX Designer', entreprise: 'DesignCo', imageUrl: 'https://picsum.photos/400/300?3' },
      { id: 4, titre: 'Marketing Digital', entreprise: 'WebBuzz', imageUrl: 'https://picsum.photos/400/300?4' }
    ];
    this.currentOffre = this.offres[0];
  }

  ngAfterViewInit(): void {
    this.setupSwipeListeners();
  }

  setupSwipeListeners(): void {
    const card = this.cardRef?.nativeElement;
    if (!card) return;

    card.addEventListener('mousedown', this.onDragStart.bind(this));
    card.addEventListener('mousemove', this.onDrag.bind(this));
    card.addEventListener('mouseup', this.onDragEnd.bind(this));

    card.addEventListener('touchstart', this.onDragStart.bind(this));
    card.addEventListener('touchmove', this.onDrag.bind(this));
    card.addEventListener('touchend', this.onDragEnd.bind(this));
  }

  onDragStart(event: MouseEvent | TouchEvent): void {
    this.isDragging = true;
    this.startX = this.getClientX(event);
    this.currentX = 0;

    const card = this.cardRef.nativeElement;
    card.style.transition = 'none';
  }

  onDrag(event: MouseEvent | TouchEvent): void {
    if (!this.isDragging) return;
    event.preventDefault();

    const clientX = this.getClientX(event);
    this.currentX = clientX - this.startX;
    const rotation = this.currentX / 15;

    const card = this.cardRef.nativeElement;
    card.style.transform = `translateX(${this.currentX}px) rotate(${rotation}deg)`;
  }

  onDragEnd(): void {
    if (!this.isDragging) return;
    this.isDragging = false;

    const card = this.cardRef.nativeElement;
    card.style.transition = 'transform 0.35s ease';

    if (this.currentX > this.SWIPE_THRESHOLD) {
      card.style.transform = 'translateX(150%) rotate(25deg)';
      setTimeout(() => this.handleMatch(true), 300);
    } else if (this.currentX < -this.SWIPE_THRESHOLD) {
      card.style.transform = 'translateX(-150%) rotate(-25deg)';
      setTimeout(() => this.handleMatch(false), 300);
    } else {
      card.style.transform = 'translateX(0) rotate(0)';
    }
  }

  handleMatch(liked: boolean): void {
    const card = this.cardRef.nativeElement;
    card.style.transition = 'none';
    card.style.transform = 'translateX(0) rotate(0)';

    if (this.offres.length > 0) {
      this.offres.shift();
      this.currentOffre = this.offres[0] || null;
      setTimeout(() => this.setupSwipeListeners(), 300);
    }
  }

  getClientX(event: MouseEvent | TouchEvent): number {
    return event instanceof MouseEvent ? event.clientX : event.touches[0].clientX;
  }
}
