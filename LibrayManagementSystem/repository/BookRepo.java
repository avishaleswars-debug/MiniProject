package LibrayManagementSystem.repository;
import java.util.*;
import LibrayManagementSystem.entity.BookEntity;

public interface interBookRepo{
    void save(BookEntity book);
    BookEntity findbyid(int id);

    void deletebook(BookEntity book);
    List<BookEntity> findAll();
}
public class BookRepo implements interBookRepo{
    public ArrayList<BookEntity> list=new ArrayList<>();
    public void save(BookEntity book){
        list.add(book);
    }
    public BookEntity findbyid(int id){
        for(BookEntity arr:list){
            if(id==arr.getbookid()){
                return arr;
            }
        }
             return null;
    }
    public void deletebook(BookEntity book){
        list.remove(book);
    }
    public List<BookEntity> findAll(){
       return list;
    }
}
