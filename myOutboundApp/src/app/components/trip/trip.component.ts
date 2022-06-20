import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from './../../services/auth.service';
import { TripService } from './../../services/trip.service';
import { Component, OnInit } from '@angular/core';
import { Trip } from 'src/app/models/trip';

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css'],
})
export class TripComponent implements OnInit {
  selected: Trip | null = null;
  newTrip: Trip = new Trip();
  editTrip: Trip | null = null;
  trips: Trip[] = [];

  currentUserId: number | null = 0;



  constructor(
    private tripServ: TripService,
    private authServ: AuthService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.currentUserId = parseInt("" + this.authServ.getCurrentUserId());
    console.log("Current user id: " + this.currentUserId);

    if(!this.selected && this.route.snapshot.paramMap.get("id")){
      let id = this.route.snapshot.paramMap.get("id");
      if(id){
      //   this.show(parseInt(id));
      // }
    }else {
    }
  this.reload();

  }

}

reload(){
  this.tripServ.indexUserTrips().subscribe({
    next: (data)=> {
      this.trips = data;

    },
    error: (err)=>{
      console.log("error in reload trip comp: " + err);

    }
  });
}

displayTrips(){[

]}


}
