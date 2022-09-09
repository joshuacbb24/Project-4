import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditGoalsComponent } from './edit-goals/edit-goals.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch:'full'},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent, data: {title: 'Dashboard'}},
  {path: 'logout', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'nav', component: NavbarComponent},
  {path: 'sidebar', component: SidebarComponent},
  {path: 'goal/:goalId', component: EditGoalsComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
