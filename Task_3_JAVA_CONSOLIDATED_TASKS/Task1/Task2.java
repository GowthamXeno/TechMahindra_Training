// Task 2 :Write a java program to accept the students name and marks in subjects and find the total and average of the
// marks and sort the list accordingly.

import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scan.nextInt();

        Student[] students = new Student[n];

        for(int i = 0 ; i < n ; i++){
            System.out.print("Enter the Student name :");
            String name = scan.next();

            System.out.print("Enter the Tamil Mark : ");
            int TM = scan.nextInt();
            System.out.print("Enter the English Mark : ");
            int EM = scan.nextInt();
            System.out.print("Enter the Maths Mark : ");
            int MM = scan.nextInt();
            System.out.print("Enter the Science Mark : ");
            int SSM = scan.nextInt();
            System.out.print("Enter the Social Mark : ");
            int SM = scan.nextInt();

            students[i] =  new Student(name,TM,EM,MM,SSM,SM);
        }

        Arrays.sort(students);
        System.out.println("The Sorted List of Students");
        for (Student student : students) {
            System.out.println("Student Name : "+student.name+" , TotalMarks : "+student.TotalMark+" , Average Marks : "+student.Average );
        }


    }
}


class Student implements Comparable<Student>{
    String name;
    int tamilMark;
    int englishMark;
    int mathsMark;
    int scienceMark;
    int socialMark;

    public Student(String name, int tamilMark, int englishMark, int mathsMark, int scienceMark, int socialMark) {
        this.name = name;
        this.tamilMark = tamilMark;
        this.englishMark = englishMark;
        this.mathsMark = mathsMark;
        this.scienceMark = scienceMark;
        this.socialMark = socialMark;

        this.TotalMark = tamilMark+englishMark+mathsMark+socialMark+scienceMark;
        this.Average = this.TotalMark/5;
    }
    int TotalMark;
    int Average;

    @Override
    public int compareTo(Student that)
    {
        return that.TotalMark - this.TotalMark;
    }

}
