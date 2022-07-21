import { catchError, throwError } from 'rxjs';
import { Gearlist } from './../models/gearlist';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class GearlistsService {

  private url = environment.baseUrl + "api/gearlists"


  constructor(private http: HttpClient, private auth:AuthService) { }

  getHttpOptions(){
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }


public indexUsersGearLists(){

  return this.http.get<Gearlist[]>(this.url,this.getHttpOptions()).pipe(
    catchError((err:any)=>{
      console.log(err);
      return throwError(()=>{
        new Error("index for user gear lists has an error");
      })
    }),
  )

}


public showGearListById(gearId: number){
  return this.http.get<Gearlist>(this.url + "/" + gearId, this.getHttpOptions()).pipe(
    catchError((err:any)=>{
      console.log(err);
      return throwError(()=>{
        new Error("single view for user gear lists has an error");
      })
    }),
  )
}


public createGearList(gearList : Gearlist){
  return this.http
    .post<Gearlist>(this.url, gearList, this.getHttpOptions())
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(() => {
          new Error('create user gear lists has an error');
        });
      })
    );
}

public addItemsToGearList(gearListId:number, items:Item[]){
    return this.http.put<Gearlist>(this.url + "/" + gearListId + "/additems", items, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(() => {
          new Error('adding items to user gearlist has an error');
        });
      })
    )

}





public updateGearList(gearList: Gearlist, gearListId: number){
  return this.http.put<Gearlist>(this.url + "/" + gearListId, gearList, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(() => {
        new Error('edit user gear lists has an error');
      });
    })
  )
}

public disableGearList(gearList : Gearlist, gearListId : number){

  return this.http.put<Gearlist>(this.url + "/disable/" + gearListId, gearList, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(() => {
        new Error('disable user gear lists has an error');
      });
    })
  )
}


public searchGearList(keyword : string){
return this.http.put<Gearlist[]>(this.url, keyword, this.getHttpOptions()).pipe(

  catchError((err: any) => {
    console.log(err);
    return throwError(() => {
      new Error('search user gear lists has an error');
    });
  })
);
}



}

