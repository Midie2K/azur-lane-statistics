export interface IFraction {
  id?: number;
  index?: string;
  name?: string;
}

export class Fraction implements IFraction {
  id?: number;
  index?: string;
  name?: string;

  constructor(data?: IFraction) {
    this.id = data?.id;
    this.index = data?.index;
    this.name = data?.name;
  }
}