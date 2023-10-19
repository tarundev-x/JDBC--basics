package com.example.studentmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import manage.Student;
import manage.StudentDao;

public class Start1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("welcome to Student management app");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to DISPLAY student");
			System.out.println("PRESS 4 to UPDATE student");
			System.out.println("PRESS 5 to EXIT student");
			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
				System.out.println("Enter UserNmae :");
				String name = br.readLine();
				System.out.println("Enter user Phone :");
				String phone = br.readLine();
				System.out.println("Enter user city :");
				String city = br.readLine();

				// create student object to store student

				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.InsertStudentToDB(st);
				if(answer)
				{
					System.out.println("Student is added Succesfully....");
				}else
				{
					System.out.println("Something went Wrong try again...");
				}
				System.out.println(st);

				// add student
			}
			else if (c == 2) 
			{
				System.out.println("Enter user id to delete: ");
				int userid=Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userid);
				if(f)
				{
					System.out.println("Deleted....");
				}
				else
				{
					System.out.println("Something went wrong...");
				}
				
				// delete student
			} 
			else if (c == 3) {
				// display student
				StudentDao.showAllStudent();
			} 
			else if (c == 4) 
			{
				//update
				System.out.println("Enter the Student ID: ");
				String idInput = br.readLine();

				try {
				    int id = Integer.parseInt(idInput);
				    
				    System.out.println("Enter new name: ");
				    String name = br.readLine();
				    System.out.println("Enter new Phone: ");
				    String phone = br.readLine();
				    System.out.println("Enter new city: ");
				    String city = br.readLine();

				    Student st = new Student(id, name, phone, city);

				    boolean answer = StudentDao.updateStudent(st);

				    if (answer) {
				        System.out.println("Updated successfully.");
				    } else {
				        System.out.println("Something went wrong.");
				    }
				} catch (NumberFormatException e) {
				    System.out.println("Invalid input for Student ID. Please enter a valid number.");
				}

				
				
			} 
			else 
			{
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
	
		
		System.out.println("Thank You for using my application.");
		System.out.println("See you s00n");
	 }
	}
}


