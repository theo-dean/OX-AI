import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../environments/environment';
import {Observable} from 'rxjs';
import { Greeter } from './Greeter';

@Injectable({
  providedIn: 'root'
})

export class BackendIoService {

  constructor(private http: HttpClient) { }

  getResponse(): Observable<Greeter> {
    return this.http.get<Greeter>(environment.apiUrl + 'greeting');
  }
}
