package LibrayManagementSystem.controller;
import java.util.*;
import LibrayManagementSystem.entity.BookEntity;
import LibrayManagementSystem.entity.BorrowEntity;
import LibrayManagementSystem.entity.BorrowStatus;
import LibrayManagementSystem.service.IBookService;
import LibrayManagementSystem.service.IBorrowService;

public class MemberMenu {
    private IBookService bookService;
    private IBorrowService borrowService;
    private Scanner scanner;
    private int currentMemberId;
    
    public MemberMenu(IBookService bookService, IBorrowService borrowService){
        this.bookService = bookService;
        this.borrowService = borrowService;
        this.scanner = new Scanner(System.in);
    }
    
    public void membermenu(){
        System.out.print("Enter your member ID: ");
        currentMemberId = scanner.nextInt();
        scanner.nextLine();
        
        while(true){
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    viewAvailableBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    viewMyBorrowedBooks();
                    break;
                case 5:
                    System.out.println("Exiting member menu...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
    
    private void displayMenu(){
        System.out.println("\n========== MEMBER MENU ==========");
        System.out.println("1. View available books");
        System.out.println("2. Borrow book");
        System.out.println("3. Return book");
        System.out.println("4. View my borrowed books");
        System.out.println("5. Exit");
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
    
    private void viewAvailableBooks(){
        System.out.println("\n--- Available Books ---");
        List<BookEntity> availableBooks = bookService.getAvailableBooks();
        if(availableBooks.isEmpty()){
            System.out.println("No books available at the moment.");
        } else {
            for(BookEntity book : availableBooks){
                System.out.println(book);
            }
        }
    }
    
    private void borrowBook(){
        System.out.println("\n--- Borrow Book ---");
        System.out.print("Enter book ID to borrow: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        BookEntity book = bookService.findBookById(bookId);
        if(book == null){
            System.out.println("Book not found!");
            return;
        }
        
        if(!book.getisAvailable()){
            System.out.println("Book is not available!");
            return;
        }
        
        BorrowEntity borrow = new BorrowEntity(bookId, currentMemberId);
        if(borrowService.issuebook(borrow)){
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Failed to borrow book. Please try again.");
        }
    }
    
    private void returnBook(){
        System.out.println("\n--- Return Book ---");
        System.out.print("Enter book ID to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        
        if(borrowService.returnbook(bookId, currentMemberId)){
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Failed to return book. You may not have borrowed this book.");
        }
    }
    
    private void viewMyBorrowedBooks(){
        System.out.println("\n--- My Borrowed Books ---");
        List<BorrowEntity> myBorrows = borrowService.getBorrowsByMemberId(currentMemberId);
        
        if(myBorrows.isEmpty()){
            System.out.println("You have not borrowed any books.");
        } else {
            List<BorrowEntity> activeBorrows = new ArrayList<>();
            for(BorrowEntity borrow : myBorrows){
                if(borrow.getStatus() == BorrowStatus.BORROWED){
                    activeBorrows.add(borrow);
                }
            }
            
            if(activeBorrows.isEmpty()){
                System.out.println("You have no active borrows.");
            } else {
                System.out.println("Active borrows:");
                for(BorrowEntity borrow : activeBorrows){
                    BookEntity book = bookService.findBookById(borrow.getBookId());
                    System.out.println("Book ID: " + borrow.getBookId() + 
                                     ", Title: " + (book != null ? book.gettitle() : "Unknown") +
                                     ", Borrow Date: " + borrow.toString());
                }
            }
        }
    }
}
