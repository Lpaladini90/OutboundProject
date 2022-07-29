import { Categories } from './../models/categories';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

  private url = environment.baseUrl + "api/gearlists"

  constructor(private http:HttpClient, private auth:AuthService) { }

  getHttpOptions(){
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  public indexAllCategories(){

    return this.http.get<Categories[]>(this.url,this.getHttpOptions()).pipe(
      catchError((err:any)=>{
        console.log(err);
        return throwError(()=>{
          new Error("index for user gear lists has an error");
        })
      }),
    )

  }


  public showCategory(catId : number){

  }



}


