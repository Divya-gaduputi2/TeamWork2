import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainContentComponent } from './main-content/main-content.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { EmpFormComponent } from './emp-form/emp-form.component';
import { EmpListComponent } from './emp-list/emp-list.component';



const routes: Routes = [
  {path:'',component:MainContentComponent},
  {path:'contact',component:ContactUsComponent},
  {path:'thank',component:ThankYouComponent},
  {path:'viewEmp',component:EmpListComponent},
  {path:'addEmp',component:EmpFormComponent},
  {path:'editEmp/:id',component:EmpFormComponent},
  {path:'**',component:PageNotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
