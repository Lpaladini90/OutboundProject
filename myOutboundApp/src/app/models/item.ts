import { User } from "./user";

export class Item {

  id:number;
  brand: string;
  description: string | null;
  weight: boolean | null;
  active: boolean | null;
  imageUrl : string  | null;
  user: User;


  constructor(
    id: number =0,
    brand: string = "",
    description: string = "",
    weight: boolean = false,
    active: boolean = true,
    imageUrl : string = "",
    user: User = new User(),
  ){
    this.id = id;
    this.brand = brand;
    this.description = description;
    this.weight = weight;
    this.active = active;
    this.imageUrl = imageUrl;
    this.user = user;
  }

  }
