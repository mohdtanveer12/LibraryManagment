package pkg_mains;

import java.util.Scanner;

import pkg_book.Book;
import pkg_book.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.StudentManager;
import pkg_transaction.BookTransactionManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner sc = new Scanner(System.in);
		BookManager bm = new BookManager();
		StudentManager sm = new StudentManager();
		BookTransactionManager btm = new BookTransactionManager();
		do {
			System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if want to Exit:");
			choice = sc.nextInt();
			if(choice == 1){// if user student 
				System.out.println("Enter Your Roll Number");
				int rollNo = sc.nextInt();
				try {
					Student s = sm.get(rollNo);
					if(s == null)
						throw new StudentNotFoundException();
					int stud_choice;
					do{
						System.out.println("Enter 1 to View All Books\nEnter 2 Search Book by ISBN\nEnter 3 to List Books By Subject\nEnetr 4 to Issue a Book\nEnter 5 to Return a Book\nEnter 99 ");
						stud_choice = sc.nextInt();
						switch(stud_choice) {
						case 1:
						System.out.println("All the Book Records are");
						bm.viewAllBooks();
						break;
						case 2:
							System.out.println(" Please Enter ISBN To Search");
							System.out.println("Enter the  ISBN interger Number of the Book to Search ");
							int serach_isbn = sc.nextInt();
							Book book = bm.searchBookByIsbn(serach_isbn);
							if(book == null)
								System.out.println("No Book with ISBN Exists in our Library");
							else
								System.out.print(book);
								
							break;
						case 3:
							System.out.println("Enter the  Subject to Search");
							sc.nextLine();
							String search_subject = sc.nextLine();
							bm.listBooksBySubject(search_subject);
							
							break;
						case 4 : // Issue Book 
							System.out.println("Enter the ISBN to Issue a Book");
							int issue_isbn = sc.nextInt();
							 book = bm.searchBookByIsbn(issue_isbn);
							 try {
								 if(book == null) {
									 throw new BookNotFoundException();
						     	 }
								 if(book.getAvailable_quantity() > 0)
								 {
									 if(btm.issueBook(rollNo, issue_isbn)) {
										 book.setAvailable_quantity(book.getAvailable_quantity() -1);
										 System.out.println("Book has been Issued ");
									 }
								 }
								 else {
									 System.out.println("The Book has been Issued ...");
								 }
							 }
							 catch(BookNotFoundException bnfe) {
								 System.out.println(bnfe);
							 }
						break;
						case 5 : // Return Book 
							System.out.println("Please Enter The ISBN to  Return  a Book ");
							int return_isbn = sc.nextInt();
							book = bm.searchBookByIsbn(return_isbn);
							if (book != null) {
								if (btm.returnBook(rollNo, return_isbn)) {
									book.setAvailable_quantity(book.getAvailable_quantity() +1);
									System.out.println("thanks you for returning the Book ");
								}
								else
								System.out.println("could Not return the Book ");
							}
							else 
								System.out.println("Book with this ISBN Does not Exists");
								
							break;
							
						case 31 :// to View all Transaction 
							System.out.println("All the Transaction are ");
							btm.showAll();
							
						case 99:
							System.out.println("Thanks You for Usaing Libaray ");
							break ;
							default :
								System.out.println("Invalid Choice");
							
						
						}
						
					}while(stud_choice !=99);
				}
				catch(StudentNotFoundException snfe) {
					System.out.println(snfe);
				}
			
			}
			
			else if(choice == 2) { // Is the libarain 
				
				int lib_choice;
			do {
				
				System.out.println("Enter 11 to View all Students\nEnter 12 to print a student by Roll Number\nEnter 13 to Register a Student\nEnter 14 to Upadate a Student\nEnter 15 to Delete a Student ");
				System.out.println("Enter 21 to View all Students\nEnter 22 to print a Book by ISBN\nEnter 23 to Register a Book\nEnter 24 to Upadate a Book\nEnter 25 to Delete a Book ");
				System.out.println("Enter 31 to view all Transaction ");
				System.out.println("Enter 99 to Exit ");
				lib_choice = sc.nextInt();
				switch(lib_choice) {
				case 11: // view all student 
					System.out.println("All the Student Recordes ");
					sm.viewAllStudent();
					break;
				case 12: // Search a student based on rollNo
					System.out.println("Enter Roll Number To fetch Student Record ");
					int get_rollNo = sc.nextInt();
					Student student = sm.get(get_rollNo);
					if(student == null);{
						System.out.println("No Record Matches this Roll Number ");
						
						
							System.out.println(student);
						break ;
					
					}
					
					
					case 13: // adding a student 
					System.out.println("Enter Student Deatials to Add");
					String name;
					String emailId;
					String phoneNumber;
					String address;
					String dob;
					int rollNo;
					int std;
					String division;
					sc.nextLine();
					System.out.println("Name");
					name = sc.nextLine();
					
					System.out.println("emailId");
					emailId = sc.nextLine();
					
					System.out.println("phoneNumber");
					phoneNumber = sc.nextLine();
					
					System.out.println("address");
					address = sc.nextLine();
					
					System.out.println("Date od Birth");
					dob = sc.nextLine();
					
					System.out.println("rollNo");
					rollNo = sc.nextInt();
					
					System.out.println("std");
					std = sc.nextInt();
					
					sc.nextLine();
					
					System.out.println("Division");
					division = sc.nextLine();
					
					student = new Student(name, emailId, phoneNumber, address, dob, rollNo, std, division);
					sm.addAStudent(student);
					System.out.println("Student is Added");
					break;
					
				case 14: // Update a Student 
					System.out.println("Enter The Roll Number to Modify te Record ");
					int modify_rollNo;
					modify_rollNo = sc.nextInt();
					student = sm.get(modify_rollNo);
					try {
					if(student == null)
						throw new StudentNotFoundException();
					sc.nextLine();
					System.out.println("Name");
					name = sc.nextLine();
					
					System.out.println("emailId");
					emailId = sc.nextLine();
					
					System.out.println("phoneNumber");
					phoneNumber = sc.nextLine();
					
					System.out.println("address");
					address = sc.nextLine();
					
					System.out.println("dob");
					dob = sc.nextLine();
										
					System.out.println("std");
					std = sc.nextInt();
					
					sc.nextLine();
					
					System.out.println("Division");
					division = sc.nextLine();
					
					
					sm.updateStudent(modify_rollNo, name, emailId, phoneNumber, address, dob, std, division);
					System.out.println("Student Record is Upadte");
					
				 	}
					catch(StudentNotFoundException snfe) {
						System.out.println(snfe);
					}
					break;
				case 15: //  to delete student 
					System.out.println("Enter The Roll Number to Delete te Record ");
					int delete_rollNo;
					delete_rollNo = sc.nextInt();
					if(sm.deleteStudent(delete_rollNo))
						System.out.println("Student Record is Removed ");
					else
						System.out.println("No Record with Given Number Exit");
					break;
					
				case 21:
					bm.viewAllBooks();
					break;
				case 22:
					int search_isbn;
					System.out.println("Enter ISBN of the book to Search ");
					search_isbn = sc.nextInt();
					Book book = bm.searchBookByIsbn(search_isbn);
					if(book == null)
						System.out.println("No Book With this ISBN Exists in our Library");
					else
						System.out.println(book);
					break;
					
				case 23 :
					System.out.println("Please Enter Book Details to Add");
					int isbn;
					String title;
					String author;
					String publisher;
					int edition;
					String subject;
					int available_quantity;
					
					System.out.println("ISBN");
					isbn = sc.nextInt();
					
					sc.nextLine();
					
					System.out.println("title");
					title = sc.nextLine();
					
					System.out.println("author");
					author = sc.nextLine();
					
					System.out.println("publisher");
					publisher = sc.nextLine();
					
					System.out.println("edition");
					edition = sc.nextInt();
					
					sc.nextLine();
					
					System.out.println("Subject");
					subject = sc.nextLine();
					
					System.out.println("available_quantity");
					available_quantity = sc.nextInt();
					
					book = new Book( isbn, title,  author,  publisher,  edition, subject, available_quantity);
					bm.addABook(book);
					System.out.println("A Book Reacodr is Added");
					break;
				case 24 : // update a record of book
					System.out.println("Pleasse Enter the ISBN to update record ");
					int update_isbn;
					update_isbn = sc.nextInt();
					try {
						book = bm.searchBookByIsbn(update_isbn);
						if(book == null)
							throw new BookNotFoundException();
						
						System.out.println("Enter Book Details to Modify");
						
						sc.nextLine();
						
						System.out.println("title");
						title = sc.nextLine();
						
						System.out.println("author");
						author = sc.nextLine();
						
						System.out.println("publisher");
						publisher = sc.nextLine();
						
						System.out.println("edition");
						edition = sc.nextInt();
						
						sc.nextLine();
						
						System.out.println("Subject");
						subject = sc.nextLine();
						
						System.out.println("available_quantity");
						available_quantity = sc.nextInt();
						
						bm.updateBook(update_isbn, title, author, edition,publisher, publisher, available_quantity);
						
					}
					catch(BookNotFoundException bnfe) {
						System.out.println(bnfe);
					}
					break;
					
				case 25: /// delete a recode a Book
					System.out.println("Please Enter the ISBN to delete the record");
					int  delete_isbn;
					delete_isbn = sc.nextInt();
					
					try {
						book = bm.searchBookByIsbn(delete_isbn);
						if(book == null)
							throw new BookNotFoundException();
						bm.deleteBook(delete_isbn);
						System.out.println("Book Record is deleted");
					}
					
					catch(BookNotFoundException bnfe) {
						System.out.println(bnfe);
					}
					break ;
					
					
				case 99:
					System.out.println("Thanks you for Using Library");
					break;
					default:
						System.out.println("Invalid Choice");
					
				}
			}while(lib_choice !=99);
			
		}
			
		}while(choice !=3);
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();

	}

}
