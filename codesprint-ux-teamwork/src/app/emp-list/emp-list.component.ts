import { Component, OnInit } from '@angular/core';
import { Emp } from '../model/emp';
import { EmpService } from '../service/emp.service';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {
  emps:Emp[];
  errMsg:string;
  
  constructor(private empService :EmpService) { }

  ngOnInit() {
    this.loadData();
  }
    loadData(){
      this.emps=null;
      this.errMsg=null;
  
      this.empService.getAll().subscribe(
        (data) =>{ this.emps=data; },
        (err) => {this.errMsg="Sorry Server not reachable!";}
      );

    }

}
