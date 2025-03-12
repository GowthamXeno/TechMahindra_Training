# Angular SPA Project

## Project Overview
This is a **Single Page Application (SPA) built with Angular** that includes essential features such as routing, components, services, API calls, and forms. The application consists of the following pages:

1. **Dashboard** - Overview of user activities.
2. **Friends Page** - Manage friends and track transactions.
3. **Expenditure Page** - Manage expenses and debts.
4. **Login Page** - Authentication with template-driven forms.

## Features
- **Components**: Modular Angular components for each feature.
- **Parent-Child Components**: Data sharing between components using `@Input`.
- **Structural & Attribute Directives**: Used for dynamic UI updates (`*ngIf`, `*ngFor`, `[ngClass]`, etc.).
- **Routing**: Configured using `RouterModule` to navigate between pages.
- **Services**: `AuthService` for authentication and `FriendsService` for fetching friend-related data.
- **Observables**: Used in services to handle asynchronous data fetching.
- **API Calls**: Fetch data from `db.json` (JSON Server used as a backend).
- **Forms**:
  - **Template-driven Forms** for Login.
  - **Reactive Forms** for the Expenditure form.
- **Pipes**: Used to format currency and dates.

## Project Structure
```
angular-spa-project/
│-- src/
│   │-- app/
│   │   │-- components/
│   │   │   │-- navbar/
│   │   │   │   │-- navbar.component.ts
│   │   │   │   │-- navbar.component.html
│   │   │   │   │-- navbar.component.css
│   │   │   │-- dashboard/
│   │   │   │   │-- dashboard.component.ts
│   │   │   │   │-- dashboard.component.html
│   │   │   │   │-- dashboard.component.css
│   │   │   │-- friends/
│   │   │   │   │-- friends.component.ts
│   │   │   │   │-- friends.component.html
│   │   │   │   │-- friends.component.css
│   │   │   │-- expenditure/
│   │   │   │   │-- expenditure.component.ts
│   │   │   │   │-- expenditure.component.html
│   │   │   │   │-- expenditure.component.css
│   │   │   │-- login/
│   │   │   │   │-- login.component.ts
│   │   │   │   │-- login.component.html
│   │   │   │   │-- login.component.css
│   │   │-- services/
│   │   │   │-- auth.service.ts
│   │   │   │-- friends.service.ts
│   │   │-- app.module.ts
│   │   │-- app-routing.module.ts
│-- db.json (Mock database for API calls)
│-- README.md
```

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/angular-spa-project.git
   cd angular-spa-project
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start JSON Server (Mock API):
   ```sh
   json-server --watch db.json
   ```
4. Run the Angular application:
   ```sh
   ng serve
   ```
5. Open the app in your browser:
   ```
   http://localhost:4200
   ```


## Future Enhancements
- **Authentication with JWT**.
- **User roles & permissions**.
- **Better UI/UX with Angular Material**.

This project serves as a solid starting point for building scalable Angular applications with essential SPA functionalities. 🚀

