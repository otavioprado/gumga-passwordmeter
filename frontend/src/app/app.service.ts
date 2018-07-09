import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from '../../node_modules/rxjs';

@Injectable()
export class AppService {

  constructor(private _httpClient: HttpClient) { 
      // Nothing to do here
  }

  checkPassword(password: string): Observable<any> {
    var dns = window.location.origin;
    var host = window.location.hostname;
    const url = "http://" + host + ':8080' + '/api/v1/password-meter/check';
    console.log(url);
    return this._httpClient.post<any>(url, { "password" : password });
  }
}