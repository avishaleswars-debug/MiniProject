# Library Management System

A Java-based console application for managing library operations including books, members, and borrowing transactions.

## Features

### Admin Features
- View all books
- Add new books
- Remove books
- Update book details
- View members
- Add members
- Filter members
- Issue books
- Return books

### Member Features
- View available books
- Borrow books
- Return books
- View borrowed books

## Project Structure

The project follows a layered architecture pattern with clear separation of concerns:

```
LibrayManagementSystem/
├── entity/              # Domain models/entities
│   ├── BookEntity.java
│   ├── BorrowEntity.java
│   └── MemberEntity.java
├── repository/          # Data access layer
│   ├── BookRepo.java
│   ├── BorrowRepo.java
│   └── MemberRepo.java
├── service/            # Business logic layer
│   ├── BookService.java
│   ├── BorrorService.java
│   └── MemberService.java
├── controller/         # Presentation/UI layer
│   ├── AdminMenu.java
│   └── MemberMenu.java
└── main/              # Application entry point
    └── Main.java
```

## Architecture

The application follows a three-tier architecture:

1. **Entity Layer** (`entity/`): Contains domain models representing core business entities
   - `BookEntity`: Represents a book with properties like ID, title, author, and availability
   - `BorrowEntity`: Represents a borrowing transaction with book ID, member ID, borrow date, and status
   - `MemberEntity`: Represents a library member with ID, name, and borrowed book count

2. **Repository Layer** (`repository/`): Handles data persistence and retrieval
   - `BookRepo`: Manages book data operations (CRUD)
   - `BorrowRepo`: Manages borrowing transaction data
   - `MemberRepo`: Manages member data operations

3. **Service Layer** (`service/`): Contains business logic
   - `BookService`: Handles book-related business operations
   - `BorrorService`: Handles borrowing and returning operations
   - `MemberService`: Handles member-related business operations

4. **Controller Layer** (`controller/`): Handles user interface and input/output
   - `AdminMenu`: Provides admin interface and menu options
   - `MemberMenu`: Provides member interface and menu options

5. **Main** (`main/`): Application entry point that wires dependencies and starts the application

## Requirements

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line compiler

## How to Compile and Run

### Using Command Line

1. **Compile all Java files:**
   ```bash
   javac entity/*.java repository/*.java service/*.java controller/*.java main/*.java
   ```

2. **Run the application:**
   ```bash
   java -cp . LibrayManagementSystem.Main
   ```

### Using an IDE

1. Open the project in your preferred Java IDE
2. Set the source root to the project directory
3. Run the `Main.java` file located in the `main/` folder

## Usage

1. **Start the application:**
   - Run the `Main.java` file
   - You will be prompted to enter your role

2. **Select your role:**
   - Type `admin` for administrator access
   - Type `member` for member access
   - Type `exit` to quit the application

3. **Admin Menu Options:**
   - Enter the number corresponding to the action you want to perform
   - Follow the prompts to complete the operation

4. **Member Menu Options:**
   - Enter the number corresponding to the action you want to perform
   - Follow the prompts to complete the operation

## Package Structure

All classes are organized under the `LibrayManagementSystem` package, allowing direct access between classes without explicit imports.

## Class Descriptions

### Entity Classes

- **BookEntity**: Represents a book with ID, title, author, and availability status
- **BorrowEntity**: Represents a borrowing transaction with book ID, member ID, borrow date, and status (BORROWED/RETURNED)
- **MemberEntity**: Represents a library member with ID, name, and number of books borrowed

### Repository Classes

- **BookRepo**: Implements `interBookRepo` interface for book data operations
- **BorrowRepo**: Implements `interBorrowBook` interface for borrowing transaction operations
- **MemberRepo**: Implements `InterMemberRepo` interface for member data operations

### Service Classes

- **BookService**: Provides business logic for book operations (add, view, remove, update)
- **BorrorService**: Handles book issuing and returning operations
- **MemberService**: Provides business logic for member operations (add, view)

### Controller Classes

- **AdminMenu**: Console-based admin interface with menu-driven operations
- **MemberMenu**: Console-based member interface with menu-driven operations

## Notes

- The application uses in-memory data storage (ArrayList) - data is not persisted between sessions
- All classes are in the same package (`LibrayManagementSystem`) for simplified access
- The application follows object-oriented principles with dependency injection for service classes

## Future Enhancements

- Database integration for persistent storage
- File-based data persistence
- Enhanced error handling and validation
- User authentication and authorization
- Search and filter functionality
- Report generation
- Due date tracking for borrowed books

## License

This project is open source and available for educational purposes.


