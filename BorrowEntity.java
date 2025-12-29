
import java.time.LocalDate;
public class BorrowEntity {

    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    private BorrowStatus status;

    public Borrow(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = LocalDate.now();
        this.status = BorrowStatus.BORROWED;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void returnBook() {
        this.status = BorrowStatus.RETURNED;
    }

}
 enum BorrowStatus {
    BORROWED,
    RETURNED
}

