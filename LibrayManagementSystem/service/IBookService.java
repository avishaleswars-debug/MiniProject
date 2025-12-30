package LibrayManagementSystem.service;

import java.util.List;
import LibrayManagementSystem.entity.BookEntity;

public interface IBookService {
    void add(BookEntity book);
    List<BookEntity> viewbook();
    boolean removebook(int id);
    boolean updatebook(int id, String title, String Author, boolean avail);
    List<BookEntity> getAvailableBooks();
    BookEntity findBookById(int id);
}

