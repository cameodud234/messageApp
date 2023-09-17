import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent} from './components/login/login.component'

const routes: Routes = [
  {
    path : "", component: LoginComponent
  },
  {
    path: "login", component: LoginComponent
  },
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
