import java.util.*;
interface interBorrowBook{
    void save(BorrowEntity borrow);
    List<BorrowEntity> findAll();
}
public class BorrowRepo implements interBorrowBook {
    
}
