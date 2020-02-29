import { Component, OnInit } from '@angular/core';
import { Emp } from '../model/emp';
import { EmpService } from '../service/emp.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-emp-form',
  templateUrl: './emp-form.component.html',
  styleUrls: ['./emp-form.component.css']
})
export class EmpFormComponent implements OnInit {
   emp:Emp;
   msg:string;
 
  constructor(
    private empService:EmpService,
    private actRoute:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit() {
    let empId=this.actRoute.snapshot.params.id;
    if(empId){
      this.empService.getAllById(empId).subscribe(
        (data) =>{
          this.emp=data;
          
        }
      );

    }else{
      this.emp={
        empId:0,
        firstName:'',
        lastName:'',
        age:0,
       mobileNumber:'',
        email:'',
        address:''
      };
     
    
}
  }

    save(){
      let ob:Observable<Emp>;
        ob=this.empService.add(this.emp);
      
      ob.subscribe(
        (Data) =>{
          this.router.navigateByUrl("");
        },
        (errResponse)=> {
          this.msg=errResponse.error;
          
        }
      );
    }
}
