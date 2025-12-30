package LibrayManagementSystem.controller;
import java.util.*;
import LibrayManagementSystem.entity.BookEntity;
import LibrayManagementSystem.service.IBookService;
import LibrayManagementSystem.service.IMemberService;
import LibrayManagementSystem.service.IBorrowService;

public class AdminMenu {
    private IBookService bookService;
    private IMemberService memberService;
    private IBorrowService borrowService;
    private Scanner scanner;
    
    public AdminMenu(IBookService bookService, IMemberService memberService, IBorrowService borrowService){
        this.bookService = bookService;
        this.memberService = memberService;
        this.borrowService = borrowService;
        this.scanner = new Scanner(System.in);
    }
    
    public void adminmenu() {
        while(true){
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    viewAllBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    updateBookDetails();
                    break;
                case 5:
                    viewAllMembers();
                    break;
                case 6:
                    addMember();
                    break;
                case 7:
                    filterMembers();
                    break;
                case 8:
                    issueBook();
                    break;
                case 9:
                    returnBook();
                    break;
                case 10:
                    System.out.println("Exiting admin menu...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
    
    private void displayMenu(){
        System.out.println("\n========== ADMIN MENU ==========");
        System.out.println("1. View all books");
        System.out.println("2. Add new book");
        System.out.println("3. Remove book");
        System.out.println("4. Update book details");
        System.out.println("5. View all members");
        System.out.println("6. Add member");
        System.out.println("7. Filter members");
        System.out.println("8. Issue a book");
        System.out.println("9. Return a book");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private int getChoice(){
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
    
    private void viewAllBooks(){
        System.out.println("\n--- All Books ---");
        List<BookEntity> books = bookService.viewbook();
        if(books.isEmpty()){
            System.out.println("No books available.");
        } else {
            for(BookEntity book : books){
                System.out.println(book);
            }
        }
    }
    
    private void addNewBook(){
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        
        BookEntity book = new BookEntity(bookId, title, author, true);
        bookService.add(book);
        System.out.println("Book added successfully!");
    }
    
    private void removeBook(){
        System.out.println("\n--- Remove Book ---");
        System.out.print("Enter book ID to remove: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        if(bookService.removebook(bookId)){
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
    
    private void updateBookDetails(){
        System.out.println("\n--- Update Book Details ---");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter new author name: ");
        String author = scanner.nextLine();
        
        System.out.print("Is book available? (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine();
        
        if(bookService.updatebook(bookId, title, author, available)){
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
    
    private void viewAllMembers(){
        System.out.println("\n--- All Members ---");
        List<MemberEntity> members = memberService.viewmember();
        if(members.isEmpty()){
            System.out.println("No members registered.");
        } else {
            for(MemberEntity member : members){
                System.out.println(member);
            }
        }
    }
    
    private void addMember(){
        System.out.println("\n--- Add New Member ---");
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        
        MemberEntity member = new MemberEntity(memberId, name, 0);
        memberService.addMember(member);
        System.out.println("Member added successfully!");
    }
    
    private void filterMembers(){
        System.out.println("\n--- Filter Members ---");
        System.out.print("Enter member name to search: ");
        String name = scanner.nextLine();
        
        List<MemberEntity> filteredMembers = memberService.filterMembersByName(name);
        if(filteredMembers.isEmpty()){
            System.out.println("No members found with that name.");
        } else {
            System.out.println("Found members:");
            for(MemberEntity member : filteredMembers){
                System.out.println(member);
            }
        }
    }
    
    private void issueBook(){
        System.out.println("\n--- Issue Book ---");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        
        BorrowEntity borrow = new BorrowEntity(bookId, memberId);
        if(borrowService.issuebook(borrow)){
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Failed to issue book. Book may not be available or member/book not found.");
        }
    }
    
    private void returnBook(){
        System.out.println("\n--- Return Book ---");
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();
        
        if(borrowService.returnbook(bookId, memberId)){
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Failed to return book. Transaction not found.");
        }
    }
}
