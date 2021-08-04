import { Injectable } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {NzNotificationService} from "ng-zorro-antd/notification";

@Injectable({
  providedIn: 'root'
})
export class ErrorService {

  constructor(private notification: NzNotificationService) { }

  handle(form: FormGroup, err: any) {
    if(err.status === 422) {

      const error = err.error;
      const validationErrors = error.errors;

      this.notification.create(
        'error',
        error.error,
        error.message,
      );

      Object.keys(validationErrors).forEach((prop) => {
        // @ts-ignore
        const formControl = form.get(prop);
        if (formControl) {
          // activate the error message
          formControl.setErrors({
            serverError: validationErrors[prop]
          });
        }
      });

    }
  }
}
