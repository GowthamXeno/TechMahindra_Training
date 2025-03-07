import { Component, Input } from '@angular/core';
import { project } from '../../model/project';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent {
   
    projectslist:project[] = [];
    selectedStatus: string = 'All';
    min: number = 0;
    max: number = 0;
    constructor(private api : ApiService){

    }
    ngOnInit(){
      this.api.getProjects().subscribe({
        next:(result :project[])=> this.projectslist = result,
        error:(error)=> console.log(error),
      })
    }
}
