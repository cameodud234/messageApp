import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'front-end';
  htmlContent: string = ""

  constructor(private appService: AppService) { }

  ngOnInit(): void {
    this.appService.getAPI_Message().subscribe(res => {
      console.log(res);
    })
  }

}
