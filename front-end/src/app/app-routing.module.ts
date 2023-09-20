import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent} from './components/login/login.component'
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { UserListComponent } from './components/user-list/user-list.component';

const routes: Routes = [
  {
    path : "" , component: HomeComponent
  },
  {
    path : "home", component: HomeComponent
  },
  {
    path: "login", component: LoginComponent
  },
  {
    path: "register", component: RegisterComponent
  },
  {
    path: "user-list", component: UserListComponent
  }
  // {
  //   path: "addUser", component: AddUserComponent, canActivate: [LoginAuthGuardService, AdminAuthGuardService]
  // },
  // {
  //   path: "search", component: SearchComponent, canActivate: [LoginAuthGuardService]
  // },
  // {
  //   path: "search-post", component: SearchComponent, canActivate: [LoginAuthGuardService]
  // },
  // {
  //   path: "dashboard", component: DashboardComponent, canActivate: [LoginAuthGuardService]
  // },
  // {
  //   path: "register", component: RegisterComponent
  // },
  // {
  //   path: "userList", component: UserListComponent, canActivate: [LoginAuthGuardService, AdminAuthGuardService]
  // },
  // {
  //   path: "addPost", component: AddPostComponent, canActivate: [LoginAuthGuardService]
  // },
  // {
  //   path: "post/:postid", component: PostComponent, canActivate: [LoginAuthGuardService]
  // },
  // {
  //   path: "comment/:postid", component: AddCommentComponent, canActivate: [LoginAuthGuardService]
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
