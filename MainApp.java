package demo;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Show All Students");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // Insert
                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    Student s = new Student(
                            id,
                            name,
                            course,
                            email,
                            address
                    );

                    dao.insertStudent(s);

                    break;

                // Update
                case 2:

                    System.out.print("Enter Student ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(uid, newCourse);

                    break;

                // Delete
                case 3:

                    System.out.print("Enter ID to Delete: ");
                    int did = sc.nextInt();

                    dao.deleteStudent(did);

                    break;

                // Select
                case 4:

                    dao.getAllStudents();

                    break;

                // Exit
                case 5:

                    System.out.println("Program Ended");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}