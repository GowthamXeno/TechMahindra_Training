import { Pipe, PipeTransform } from '@angular/core';
import { project } from '../model/project';

@Pipe({
  name: 'filterteamsize'
})
export class FilterteamsizePipe implements PipeTransform {

  transform(target: project[], min:number,max:number):project[] {
    if(min === 0 && max === 0){
      return target;
    }
    return target.filter(project => project.teamSize >= min && project.teamSize <= max);
  }

}
