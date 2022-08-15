import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { Trip } from '../models/trip';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TripService {

  private url = environment.baseUrl + "api/trips"



  constructor(private http: HttpClient, private auth:AuthService) { }


  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  public indexUserTrips(){
    return this.http.get<Trip[]>(this.url, this.getHttpOptions()).pipe(
      catchError((err:any)=>{
        console.log(err);
        return throwError(()=>{
          new Error("index for user trips has an error");
        })

      }),

    )
  }


public addUserTrip(newTrip: Trip){
  return this.http.post<Trip>(this.url, newTrip, this.getHttpOptions()).pipe(
    catchError((err:any)=>{
      console.log(err);
      return throwError(()=>{
        new Error("index for user trips has an error");
      })

    }),
  )

}


public updateUserTrip(updateTrip: Trip, id: number){
  return this.http.put<Trip>(this.url + "/" + id, updateTrip, this.getHttpOptions()).pipe(

    catchError((err:any)=>{
      console.log(err);
      return throwError(()=>{
        new Error("index for user trips has an error");
      })

    }),
  )
}


}
