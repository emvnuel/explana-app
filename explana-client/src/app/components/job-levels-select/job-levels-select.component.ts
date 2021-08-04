import {Component, forwardRef, OnInit} from '@angular/core';
import {JobService} from "../../services/job.service";
import {Observable} from "rxjs";
import {NamedResponse} from "../../models/named-response.model";
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";

@Component({
  selector: 'app-job-levels-select',
  templateUrl: './job-levels-select.component.html',
  styleUrls: ['./job-levels-select.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => JobLevelsSelectComponent),
      multi: true
    }
  ]
})
export class JobLevelsSelectComponent implements OnInit, ControlValueAccessor {

  constructor(private jobService: JobService) { }

  jobsLevels$!: Observable<NamedResponse<string>[]>;

  onChange: any = () => {}
  onTouch: any = () => {}
  val= ""

  set value(val: string){
    if( val !== undefined && this.val !== val){
      this.val = val
      this.onChange(val)
      this.onTouch(val)
    }

  }

  writeValue(value: any){
    this.value = value
  }

  registerOnChange(fn: any){
    this.onChange = fn
  }

  registerOnTouched(fn: any){
    this.onTouch = fn
  }

  ngOnInit(): void {
    this.jobsLevels$ = this.jobService.findAllJobLevels();
  }
}
