import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:4500/users';

  constructor(private http: HttpClient) {}

  login(usernameOrEmail: string, password: string): Observable<boolean> {
    return this.http.get<any[]>(this.apiUrl).pipe(
      map(users => {
        const user = users.find(u => 
          (u.username === usernameOrEmail || u.email === usernameOrEmail) && u.password === password
        );
        if (user) {
          localStorage.setItem('user', JSON.stringify(user));
          return true;
        }
        return false;
      })
    );
  }

  logout() {
    localStorage.removeItem('user');
  }

  isAuthenticated(): boolean {
    return localStorage.getItem('user') !== null;
  }
}
