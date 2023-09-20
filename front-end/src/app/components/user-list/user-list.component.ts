import { Component } from '@angular/core';
import { User } from 'src/app/models/user.Model';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {

  users: User[] = [];

  ngOnInit(): void {
  }

  getUsers() {
  }

}
