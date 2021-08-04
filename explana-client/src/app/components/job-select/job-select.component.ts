import {Component, forwardRef, OnInit} from '@angular/core';
import {ControlValueAccessor, NG_VALUE_ACCESSOR} from "@angular/forms";
import {JobService} from "../../services/job.service";
import {Observable} from "rxjs";
import {NamedResponse} from "../../models/named-response.model";

@Component({
  selector: 'app-job-select',
  templateUrl: './job-select.component.html',
  styleUrls: ['./job-select.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => JobSelectComponent),
      multi: true
    }
  ]
})
export class JobSelectComponent implements OnInit, ControlValueAccessor {


  constructor(private jobService: JobService) { }

  jobs$!: Observable<NamedResponse<string>[]>;

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
    this.jobs$ = this.jobService.findAllJobs();
  }

}
