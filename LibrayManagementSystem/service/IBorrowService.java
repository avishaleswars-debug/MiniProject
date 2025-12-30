package LibrayManagementSystem.service;

import java.util.List;
import LibrayManagementSystem.entity.BorrowEntity;
import LibrayManagementSystem.entity.BorrowStatus;

public interface IBorrowService {
    boolean issuebook(BorrowEntity borrow);
    boolean returnbook(int bookId, int memberId);
    boolean returnbook(BorrowEntity borrow); // Overloaded for convenience
    List<BorrowEntity> getBorrowsByMemberId(int memberId);
    List<BorrowEntity> getBorrowsByBookId(int bookId);
    List<BorrowEntity> getAllBorrows();
}

