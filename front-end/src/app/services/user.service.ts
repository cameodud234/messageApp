import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { User } from '../models/user.Model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8000';
  private usersEndpoint = '/users';

  constructor(private http: HttpClient) { }

  getUsers() {
    return this.http.get(`${this.baseUrl}${this.usersEndpoint}`)
  }

  addUser(user: User) {
    return this.http.post(`${this.baseUrl}${this.usersEndpoint}`, user)
  }

  updateUser(user: User) {
    return this.http.put(`${this.baseUrl}${this.usersEndpoint}/${user.id}`, user)
  }

  deleteUser(userId: number) {
    return this.http.delete(`${this.baseUrl}${this.usersEndpoint}/${userId}`)
  }

}
