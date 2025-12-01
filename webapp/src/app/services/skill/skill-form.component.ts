import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ISkill, SkillType } from '../../entities/skill.model';

@Component({
  selector: 'app-skill-form',
  standalone: true,
  templateUrl: './skill-form.component.html',
  imports: [CommonModule, FormsModule, ReactiveFormsModule, RouterModule],
})
export class SkillFormComponent implements OnInit {
  @Output() saveSuccess = new EventEmitter<boolean>();

  private apiUrl = 'http://localhost:8080/api/skill';

  editForm!: FormGroup;
  isSaving = false;

  skill?: ISkill;

  shipId!: number;
  skillTypes: string[] = [];

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) {
    this.createForm();
  }

  ngOnInit(): void {
    this.shipId = Number(this.route.snapshot.paramMap.get('id'));

    this.skillTypes = Object.values(SkillType);

    const skillId = this.route.snapshot.queryParamMap.get('id');
    if (skillId) {
      this.http.get<ISkill>(`${this.apiUrl}/${skillId}`).subscribe(skill => {
        this.skill = skill;

        this.editForm.patchValue({
          id: skill.id,
          name: skill.name,
          description: skill.description,
          skillType: skill.skillType,
          shipId: this.shipId
        });
      });
    } else {
      this.editForm.patchValue({ shipId: this.shipId });
    }
  }

  createForm(): void {
    this.editForm = this.fb.group({
      id: [null],
      name: [''],
      description: [''],
      skillType: [null],
      shipId: [null]
    });
  }

  save(): void {
    this.isSaving = true;

    const data = this.createFromForm();

    if (data.id) {
      this.http.put<ISkill>(this.apiUrl, data).subscribe(() => {
        this.router.navigate(['/ship', data.shipId]);
      });
    } else {
        this.http.post<ISkill>(this.apiUrl, data).subscribe(() => {
        this.router.navigate(['/ship', data.shipId]);
      });
    }

    setTimeout(() => {
      this.isSaving = false;
      this.saveSuccess.emit(true);
    }, 500);
  }

  private createFromForm(): ISkill {
    const raw = this.editForm.getRawValue();
    return {
      id: raw.id,
      name: raw.name,
      description: raw.description,
      skillType: raw.skillType,
      shipId: this.shipId
    };
  }
}
