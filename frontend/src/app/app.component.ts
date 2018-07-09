import { Component, InjectionToken, OnInit } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Inject, Injectable } from '@angular/core';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  password: string;
  result: any;
  progressValue: number;

  constructor(private _appService : AppService, @Inject(DOCUMENT) private document: any){
    this.result = {};
    this.progressValue;
  }

  ngOnInit(): void {
    document.getElementById('result').style.pointerEvents = 'none';
    document.getElementById('percentage').style.pointerEvents = 'none';
  }

  calculatePasswordSecurity() {
    console.log(this.password);

    this._appService.checkPassword(this.password).subscribe(
      success => {
        console.log(success);
        this.result = success;
        this.progressValue = success.score;
      },
      error => {
        console.log(error);
        this.cleanFields();
      }
    );
  }

  private cleanFields() {
    this.result = {};
  }
}
