import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { IShip, Rarity } from '../../entities/ship.model';
import { ShipService } from './ship.service';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ISkill, SkillType } from '../../entities/skill.model';
import { SkillService } from '../skill/skill.service';

@Component({
  selector: 'app-ship-details',
  templateUrl: './ship-details.component.html',
  styleUrls: ['./ship.component.css'],
  imports: [CommonModule, RouterModule]
})
export class ShipDetailsComponent implements OnInit {
  ship?: IShip;
  skills?: ISkill[];

  constructor(
    private route: ActivatedRoute,
    private shipsService: ShipService,
    private skillService: SkillService,
    private cd: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
        const id = Number(params.get('id'));
        this.fetchShip(id);
        this.fetchSkills(id);
    });
    }

  private fetchShip(id: number) {
    this.shipsService.getShipById(id).subscribe({
      next: (data) => {
        this.ship = data;
        this.cd.detectChanges();
      },
      error: (err) => {
        console.error('Fetch error', err);
      }
    });
  }

  private fetchSkills(id?: number){
    this.skillService.getSkillsByShipId(id).subscribe({
      next: (data)=>{
        this.skills = data;
        this.cd.detectChanges();
      },
      error: (err) => {
        console.error('Fetch error', err);
      }
    });
  }

  formatTime(seconds?: number | string): string {
    if (seconds == null) return '';

    if (seconds == 0) return 'DROP / EXCHANGE';
    
    const totalSeconds = Number(seconds);
    if (isNaN(totalSeconds)) return '';
    
    const h = Math.floor(totalSeconds / 3600);
    const m = Math.floor((totalSeconds % 3600) / 60);
    const s = totalSeconds % 60;
    return `${h}:${m.toString().padStart(2, '0')}:${s.toString().padStart(2, '0')}`;
  }

  getRarityClass(rarity?: Rarity): string {
    switch (rarity) {
      case Rarity.COMMON: return 'rarity-common';
      case Rarity.RARE: return 'rarity-rare';
      case Rarity.ELITE: return 'rarity-elite';
      case Rarity.SUPER_RARE: return 'rarity-super_rare';
      case Rarity.ULTRA_RARE: return 'rarity-ultra_rare';
      default: return '';
    }
  }

  getSkillClass(skill?: SkillType): string {
    switch (skill) {
      case SkillType.OFFENSIVE: return 'skilltype-offensive';
      case SkillType.DEFENSIVE: return 'skilltype-defensive';
      case SkillType.SUPPORT: return 'skilltype-support';

      default: return '';
    }
  }
}
