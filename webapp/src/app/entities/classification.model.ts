export interface IClassification {
  id?: number;
  index?: string;
  name?: string;
}

export class Classification implements IClassification {
  id?: number;
  index?: string;
  name?: string;

  constructor(data?: IClassification) {
    this.id = data?.id;
    this.index = data?.index;
    this.name = data?.name;
  }
}
