export interface IShip {
  id?: number;
  name?: string;

  fractionId?: number;
  fractionIndex?: string;
  fractionName?: string;

  classificationId?: number;
  classificationIndex?: string;
  classificationName?: string;

  shipClassId?: number;
  shipClassName?: string;

  hp?: number;
  fp?: number;
  trp?: number;
  avi?: number;
  aa?: number;
  rld?: number;
  evi?: number;
  spd?: number;
  acc?: number;
  lck?: number;
  asw?: number;
  armor?: Armor;

  eventId?: number;
  eventName?: string;

  rarity?: Rarity;
  buildTime?: number;
  avatar?: string;
}

export enum Armor {
  LIGHT = "LIGHT",
  MEDIUM = "MEDIUM",
  HEAVY = "HEAVY"
}

export enum Rarity {
  COMMON = "COMMON",
  RARE = "RARE",
  ELITE = "ELITE",
  SUPER_RARE = "SUPER_RARE",
  ULTRA_RARE = "ULTRA_RARE"
}

export class Ship implements IShip {
  constructor(
    public id: number,
    public name: string,

    public fractionId: number,
    public fractionIndex: string,
    public fractionName: string,

    public classificationId: number,
    public classificationIndex: string,
    public classificationName: string,

    public shipClassId: number,
    public shipClassName: string,

    public hp: number,
    public fp: number,
    public trp: number,
    public avi: number,
    public aa: number,
    public rld: number,
    public evi: number,
    public spd: number,
    public acc: number,
    public lck: number,
    public asw: number,
    public armor: Armor,

    public eventId: number,
    public eventName: string,

    public rarity: Rarity,
    public buildTime: number,
    public avatar?: string
  ) {}
}
