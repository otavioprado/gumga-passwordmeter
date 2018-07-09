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

  result: any;
  progressValue: number;

  constructor(private _appService : AppService, @Inject(DOCUMENT) private document: any){
    this.result = {};
    this.progressValue = 0;
  }

  ngOnInit(): void {
    document.getElementById('result').style.pointerEvents = 'none';
    document.getElementById('percentage').style.pointerEvents = 'none';
  }

  calculatePasswordSecurity() {
    this._appService.checkPassword("").subscribe(
      success => {
        this.result = success;
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
