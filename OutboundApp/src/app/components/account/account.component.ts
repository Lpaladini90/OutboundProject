import { AuthService } from 'src/app/services/auth.service';

import { Component, OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';



@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  title: string = 'Account';


  currentUserId: number = 0;
  users: User[] = [];
  currentUser: User = new User();
  editedUser: User | null = new User();
  editUser: boolean = false;

  displayFeed :boolean = true;
  displayMyPosts : boolean = true;
  displayEditForm: boolean = true;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userSvc: UserService,
    private authSvc: AuthService,


  ) {}



  ngOnInit(): void {
    this.currentUserId = parseInt(""+this.authSvc.getCurrentUserId());
    this.reload();
  }

  reload() {


        this.userSvc.show(this.currentUser.id).subscribe(
          { // OBJECT
            next: (user) => {
              this.getUser();
              this.editUser = false;
              this.currentUser = user;
          },

      error: (err) => {
        console.error(err);
      },
    });
  }




  getUser() {
    const username = this.authSvc.getLoggedInUser();
    if(username !== null) {
    this.authSvc.getLoggedInUser().subscribe ({
        next: (user: User) => {
          this.currentUser = user;

        },
        error: (err: any) => {
          console.error('Error retreiving userinfo' + err);

        }
      });
    }
  }



  updateUser(user: User) {
    this.userSvc.update(user).subscribe({
      next: (userUpdated) => {
        this.editedUser = null;
        if(user.username != null) {
          this.currentUser = userUpdated;
        }

      },
      error: (err) => {
        console.error('Error updating user ' + err);

      }
    });
  }

  displayAllFeed(){
   this.displayFeed = true;

  }


  todaysDate(){
    let today = new Date();
    return today.toLocaleDateString();
  }

}

