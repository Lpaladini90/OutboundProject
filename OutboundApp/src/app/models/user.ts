export class User {



  id: number;
  username: string | null;
  password: string | null;
  email: string | null;
  firstName: string | null;
  lastName: string | null;
  role: string | null;
  biography: string | null;
  imageUrl: string | null;
  active: boolean | null;


  constructor(
    id: number = 0,
    username: string = '',
    password: string = '',
    email: string = '',
    firstName: string= "",
    lastName: string ="",
    role: string ="",
    biography: string ="",
    active: boolean = true,
    imageUrl: string =""



  ) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
    this.biography = biography;
    this.active = active;
    this.imageUrl = imageUrl;

  }

}
