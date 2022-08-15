import { User } from "./user";

export class Trip {

id:number;
name: string;
description: string | null;
success: boolean | null;
startDate: string | null;
endDate: string | null;
createDate: string | null;
enabled: boolean | null;
imageUrl : string  | null;
user: User;


constructor(
  id: number =0,
  name: string = "",
  description: string = "",
  success: boolean = false,
  enabled: boolean = true,
  startDate: string ="",
  endDate: string ="",
  createDate: string ="",
  imageUrl : string = "",
  user: User = new User(),
){
  this.id = id;
  this.name = name;
  this.description = description;
  this.success = success;
  this.enabled = enabled;
  this.startDate = startDate;
  this.endDate = endDate;
  this.createDate = createDate;
  this.imageUrl = imageUrl;
  this.user = user;
}

}
