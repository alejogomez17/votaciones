import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Peticion } from '../modelos/Peticion';

@Injectable({
  providedIn: 'root'
})
export class ConsumoService {

  private url: string = "http://34.66.246.14:10000/";
  constructor(public http: HttpClient) { }

  getPeticion(ruta: string): Observable<any> {
    return this.http.get(this.url + ruta);
  }

  postPeticion(ruta: string, parametros: Peticion): Observable<any> {
    let json = JSON.stringify(parametros);
    let params = json;
    let headers = new HttpHeaders({'Content-Type':'application/json;charset=UTF-8'});
    return this.http.post(this.url + ruta, params, { headers: headers });
  }
}
