import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SettingComponent } from './setting/setting.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SettingContactComponent } from './setting-contact/setting-contact.component';
import { SettingProfileComponent } from './setting-profile/setting-profile.component';

const routes: Routes = [
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'home',component: HomeComponent },
  {
    path:'settings',
    component:SettingComponent,
    children: [
      {path:'contact',component:SettingContactComponent},
      {path:'profile',component:SettingProfileComponent}
    ]
  },
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
