import { Injectable } from '@angular/core';

@Injectable()
export class TestService {

  constructor() { }
  printToConsole(arg:string){
    console.log("hello "+arg);
  }
}
