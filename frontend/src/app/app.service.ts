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
    const url = dns + '/api/v1/password-meter/check';
    return this._httpClient.post<any>(url, { "password" : password });
  }
}