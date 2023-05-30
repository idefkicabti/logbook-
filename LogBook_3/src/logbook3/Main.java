package logbook3;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
		// Create an ArrayList to store borrowers
	    static ArrayList<Borrower> borrowers = new ArrayList<>();
	    // Define admin username and password
	    static String adminUsername = "admin";
	    static String adminPassword = "123";
	    static Scanner in = new Scanner(System.in);
	    
		public static void main(String[] args) {
	        while (true) {
	            System.out.println("1. Log in as admin");
	            System.out.println("2. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = in.nextInt();
	            in.nextLine();
	            if (choice == 1) {
	                if (login()) {
	                    adminMenu();
	                } else {
	                    System.out.println("Invalid login credentials!");
	                }
	            } else if (choice == 2) {
	                // Exit the program
	                System.out.println("Thank you for using our library!");
	                System.exit(0);
	            } else {
	                System.out.println("Invalid choice!");
	            }
	        }
	    }

	    // Function to handle admin login
	    public static boolean login() {
	        System.out.print("Enter username: ");
	        String username = in.nextLine();
	        System.out.print("Enter password: ");
	        String password = in.nextLine();
	        return username.equals(adminUsername) && password.equals(adminPassword);
	    }

	    // Function to handle admin menu
	    public static void adminMenu() {
	        while (true) {
	            System.out.println("1. Add borrower");
	            System.out.println("2. View borrowers");
	            System.out.println("3. Search borrower by name");
	            System.out.println("4. Delete borrower by name");
	            System.out.println("5. Logout");
	            System.out.print("Enter your choice: ");
	            int adminChoice = in.nextInt();
	            in.nextLine();
	            switch (adminChoice) {
	                case 1:
	                    addBorrower();
	                    break;
	                case 2:
	                    viewBorrowers();
	                    break;
	                case 3:
	                    searchBorrowerByName();
	                    break;
	                case 4:
	                    deleteBorrowerByName();
	                    break;
	                case 5:
	                    System.out.println("Logged out successfully!");
	                    return;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }

	    // Function to add a new borrower
	    public static void addBorrower() {
	        System.out.print("Enter date: ");
	        String date = in.nextLine();
	        System.out.print("Enter time: ");
	        String time = in.nextLine();
	        System.out.print("Enter item: ");
	        String item = in.nextLine();
	        System.out.print("Enter quantity: ");
	        String quantity = in.nextLine();
	        System.out.print("Enter grade level: ");
	        String gradeLevel = in.nextLine();
	        System.out.print("Enter section: ");
	        String section = in.nextLine();
	        System.out.print("Enter name: ");
	        String name = in.nextLine();

	        borrowers.add(new Borrower(date, time, item, quantity, gradeLevel, section, name));
	        System.out.println("Borrower added successfully!");
	    }

	    // Function to view all borrowers
	    public static void viewBorrowers() {
	        if (borrowers.isEmpty()) {
	            System.out.println("There are no borrowers for today. Try another option.");
	        } else {
	            for (Borrower borrower : borrowers) {
	                System.out.println(borrower);
	            }
	        }
	    }

	    // Function to search for a borrower by name
	    public static void searchBorrowerByName() {
	        if (borrowers.isEmpty()) {
	            System.out.println("There are no borrowers yet.");
	        } else {
	            System.out.print("Enter name to search: ");
	            String nameToSearch = in.nextLine();
	            boolean borrowerFound = false;
	            for (Borrower borrower : borrowers) {
	                if (borrower.getName().equals(nameToSearch)) {
	                    System.out.println(borrower);
	                    borrowerFound = true;
	                }
	            }
	            if (!borrowerFound) {
	                System.out.println("No borrower found with the given name.");
	            }
	        }
	    }

	    // Function to delete a borrower by name
	    public static void deleteBorrowerByName() {
	        System.out.print("Enter name to delete: ");
	        String nameToDelete = in.nextLine();
	        boolean borrowerDeleted = false;
	        Borrower borrowerToDelete = null;

	        for (Borrower borrower : borrowers) {
	            if (borrower.getName().equals(nameToDelete)) {
	                borrowerToDelete = borrower;
	                borrowerDeleted = true;
	                break;
	            }
	        }

	        if (borrowerDeleted) {
	            borrowers.remove(borrowerToDelete);
	            System.out.println("Borrower deleted successfully!");
	        } else {
	            System.out.println("Borrower not found.");
	        }
	    }
	}