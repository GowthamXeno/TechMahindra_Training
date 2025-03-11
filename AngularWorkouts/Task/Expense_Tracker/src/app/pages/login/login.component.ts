import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.fb.group({
      usernameOrEmail: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onLogin() {
    if (this.loginForm.valid) {
      const { usernameOrEmail, password } = this.loginForm.value;

      this.authService.login(usernameOrEmail, password).subscribe(success => {
        if (success) {
          this.router.navigate(['/dashboard']);
        } else {
          this.errorMessage = 'Invalid credentials!';
        }
      });
    }
  }
}
