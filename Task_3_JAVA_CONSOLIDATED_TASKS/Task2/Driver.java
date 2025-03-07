// Create a class named Employee with the following details:
// * empId ::int
// * empName :: String
// * sal ::double
// Methods
// getEmployeeDetails()
// setEmployeeDetails()
// getLoanEligibility()
// check ifthe employee is eligible to get loan.The conditions are:
// * an employee should have worked for greater than 5 years.
// * If his/her annualsalary is 6 lakhs then 2 lakhs of loan is granted.
// * If his/her annualsalary is >=10lakhs then 5 lakhs of loan is granted.
// * If his/her annualsalary is >=15lakhs then 7 lakhs of loan is granted.
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee emp = new Employee();


        emp.setEmployeeDetails(scanner);


        emp.getEmployeeDetails();


        if (emp.getLoanEligibility()) {
            int loanAmount = emp.GrantLoanAmt();
            System.out.println(emp.getEmpName() + " is eligible for a loan of " + loanAmount + " lakhs.");
        } else {
            System.out.println(emp.getEmpName() + " is not eligible for a loan.");
        }

        scanner.close();
    }
}

class Employee {
    private int empId;
    private String empName;
    private double annualSalary;
    private int yearOfExperience;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double salary) {
        this.annualSalary = salary;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(int yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    public void setEmployeeDetails(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        this.empId = scanner.nextInt();

        System.out.print("Enter Employee Name: ");
        scanner.nextLine(); 
        this.empName = scanner.nextLine();

        System.out.print("Enter Annual Salary (in lakhs): ");
        this.annualSalary = scanner.nextDouble();

        System.out.print("Enter Years of Experience: ");
        this.yearOfExperience = scanner.nextInt();
    }

    public void getEmployeeDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Annual Salary: " + annualSalary + " lakhs");
        System.out.println("Years of Experience: " + yearOfExperience);
    }

    public boolean getLoanEligibility() {
        return yearOfExperience > 5 && annualSalary >= 6;
    }


    public int GrantLoanAmt() {
        if (annualSalary >= 15) {
            return 7;
        } else if (annualSalary >= 10) {
            return 5;
        } else if (annualSalary >= 6) {
            return 2;
        }
        return 0;
    }
}
