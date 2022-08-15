import { AuthService } from 'src/app/services/auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { Item } from '../models/item';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private url = environment.baseUrl + "api/items"


  constructor(private http: HttpClient, private auth : AuthService) { }

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  public indexUserItems(){
    return this.http.get<Item[]>(this.url, this.getHttpOptions()).pipe(
      catchError((err:any)=>{
        console.log(err);
        return throwError(()=>{
          new Error("index for user items has an error");
        })

      }),

    )
  }

  public showItemById(itemId: number){
    return this.http.get<Item>(this.url + "/" + itemId, this.getHttpOptions()).pipe(
      catchError((err:any)=>{
        console.log(err);
        return throwError(()=>{
          new Error("single view for user gear lists has an error");
        })
      }),
    )
  }



  public addUserItem(newItem: Item){
    return this.http.post<Item>(this.url, newItem, this.getHttpOptions()).pipe(
      catchError((err:any)=>{
        console.log(err);
        return throwError(()=>{
          new Error("adding user item has an error");
        })

      }),
    )

  }

  public updateUserItem(updateItem: Item, id: number){
    return this.http.put<Item>(this.url + "/" + id, updateItem, this.getHttpOptions()).pipe(

      catchError((err:any)=>{
        console.log(err);
        return throwError(()=>{
          new Error("update for user item has an error");
        })

      }),
    )
  }
  public disableItem(item : Item, itemId : number){

    return this.http.put<Item>(this.url + "/disable/" + itemId, item, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(() => {
          new Error('disable user item has an error');
        });
      })
    )
  }


  public searchItems(keyword : string){
  return this.http.put<Item[]>(this.url, keyword, this.getHttpOptions()).pipe(

    catchError((err: any) => {
      console.log(err);
      return throwError(() => {
        new Error('search user items has an error');
      });
    })
  );
  }



}
