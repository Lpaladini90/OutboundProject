export class Categories {
  id: number;
  type: string;
  descrption: string;
  active: boolean;

  constructor(
    id: number = 0,
    type: string = '',
    description: string = '',
    active: boolean = true
  ) {
    this.id = id;
    this.type = type;
    this.descrption = description;
    this.active = active;
  }
}
