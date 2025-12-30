package LibrayManagementSystem.service;

import java.util.List;
import LibrayManagementSystem.entity.BookEntity;
import LibrayManagementSystem.repository.interBookRepo;

public class BookService implements IBookService {
    private interBookRepo bookrepo;
   
    public BookService(interBookRepo bookrepo){
        this.bookrepo=bookrepo;
    }
    public void add(BookEntity book){
        bookrepo.save(book);
    }
    public List<BookEntity> viewbook(){
        return bookrepo.findAll();
    }
    public boolean removebook(int id){
        BookEntity book = bookrepo.findbyid(id);
        if(book != null){
            bookrepo.deletebook(book);
            return true;
        }
        return false;
    }
    public boolean updatebook(int id,String title,String Author,boolean avail){
        BookEntity existingbook=bookrepo.findbyid(id);
        if(existingbook==null){
            return false;
        }
        existingbook.settitle(title);
        existingbook.setAuthor(Author);
        existingbook.setisAvailable(avail);
        return true;
    }
    
    public List<BookEntity> getAvailableBooks(){
        List<BookEntity> allBooks = bookrepo.findAll();
        List<BookEntity> availableBooks = new java.util.ArrayList<>();
        for(BookEntity book : allBooks){
            if(book.getisAvailable()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
    public BookEntity findBookById(int id){
        return bookrepo.findbyid(id);
    }

}
