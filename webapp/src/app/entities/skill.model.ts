export interface ISkill {
  id?: number;

  skillType?: SkillType;

  name?: string;
  description?: string;

  shipId?: number;
}

export enum SkillType {
  OFFENSIVE = "OFFENSIVE",
  DEFENSIVE = "DEFENSIVE",
  SUPPORT = "SUPPORT"
}


export class Skill implements ISkill {
  constructor(
    public id: number,

    public skillType: SkillType,

    public name: string,
    public description: string,

    public shipId: number
  ) {}
}