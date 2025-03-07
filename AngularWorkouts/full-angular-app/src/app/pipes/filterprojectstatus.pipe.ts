import { Pipe, PipeTransform } from '@angular/core';
import { project } from '../model/project';

@Pipe({
  name: 'filterprojectstatus'
})
export class FilterprojectstatusPipe implements PipeTransform {

  transform(target: project[], selectedStatus: string): project[] {
    if(selectedStatus === 'All') 
      return target;

    return target.filter(project => project.status === selectedStatus);
  }

}
