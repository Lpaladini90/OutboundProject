import { User } from "./user";

export class Gearlist {
  id:number;
  title: string;
  description: string | null;
  totalWeight: boolean | null;
  active: boolean | null;
  imageUrl : string  | null;
  user: User;


  constructor(
    id: number =0,
    title: string = "",
    description: string = "",
    totalWeight: boolean = false,
    active: boolean = true,
    imageUrl : string = "",
    user: User = new User(),
  ){
    this.id = id;
    this.title = title;
    this.description = description;
    this.totalWeight = totalWeight;
    this.active = active;
    this.imageUrl = imageUrl;
    this.user = user;
  }

  }
