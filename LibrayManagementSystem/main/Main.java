package LibrayManagementSystem.main;
import java.util.*;

import LibrayManagementSystem.repository.BookRepo;
import LibrayManagementSystem.repository.interBookRepo;
import LibrayManagementSystem.repository.MemberRepo;
import LibrayManagementSystem.repository.InterMemberRepo;
import LibrayManagementSystem.repository.BorrowRepo;
import LibrayManagementSystem.repository.interBorrowBook;
import LibrayManagementSystem.service.BookService;
import LibrayManagementSystem.service.IBookService;
import LibrayManagementSystem.service.BorrorService;
import LibrayManagementSystem.service.IBorrowService;
import LibrayManagementSystem.service.MemberService;
import LibrayManagementSystem.service.IMemberService;
import LibrayManagementSystem.controller.AdminMenu;
import LibrayManagementSystem.controller.MemberMenu;

public class Main {
    private static Scanner scanner;
    private static IBookService bookService;
    private static IMemberService memberService;
    private static IBorrowService borrowService;
    private static AdminMenu adminMenu;
    private static MemberMenu memberMenu;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        
        // Dependency Injection - Wiring all dependencies
        initializeDependencies();
        
        // Start application
        runApplication();
        
        scanner.close();
    }
    
    /**
     * Initializes all dependencies following Dependency Inversion Principle
     * High-level modules depend on abstractions (interfaces), not concrete classes
     */
    private static void initializeDependencies(){
        // Repository layer - Data access
        interBookRepo bookRepo = new BookRepo();
        InterMemberRepo memberRepo = new MemberRepo();
        interBorrowBook borrowRepo = new BorrowRepo();
        
        // Service layer - Business logic (depends on repository interfaces)
        bookService = new BookService(bookRepo);
        memberService = new MemberService(memberRepo);
        borrowService = new BorrorService(bookRepo, memberRepo, borrowRepo);
        
        // Controller layer - Presentation (depends on service interfaces)
        adminMenu = new AdminMenu(bookService, memberService, borrowService);
        memberMenu = new MemberMenu(bookService, borrowService);
    }
    
    /**
     * Main application loop - Single Responsibility: Only handles user role selection
     */
    private static void runApplication(){
        System.out.println("========== LIBRARY MANAGEMENT SYSTEM ==========");
        
        while(true){
            displayRoleMenu();
            String role = getUserInput().toLowerCase().trim();
            
            switch (role) {
                case "admin":
                    adminMenu.adminmenu();
                    break;
                case "member":
                    memberMenu.membermenu();
                    break;
                case "exit":
                    System.out.println("Thank you for using Library Management System!");
                    return;
                default:
                    System.out.println("Invalid role! Please enter 'admin', 'member', or 'exit'.");
                    break;
            }
        }
    }
    
    /**
     * Displays the role selection menu
     */
    private static void displayRoleMenu(){
        System.out.println("\n--- Select Your Role ---");
        System.out.println("Enter 'admin' for administrator access");
        System.out.println("Enter 'member' for member access");
        System.out.println("Enter 'exit' to quit");
        System.out.print("Your choice: ");
    }
    
    /**
     * Gets user input from scanner
     */
    private static String getUserInput(){
        return scanner.nextLine();
    }
}
