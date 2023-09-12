import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})

export class UserServiceService {

  private baseUrl = 'http://localhost:8000/api';
  private usersEndpoint = '/users';

  constructor(private http: HttpClient) { }

  getUsers() {
    return this.http.get(`${this.baseUrl}${this.usersEndpoint}`)
  }

  addUser(user: User) {
    return this.http.post(`${this.baseUrl}${this.usersEndpoint, user}`)
  }

  deleteUser(userId: number) {
    return this.http.delete(`${this.baseUrl}${this.usersEndpoint}/${userId}`)
  }

  // Service method for making API calls will be defined here.

}
