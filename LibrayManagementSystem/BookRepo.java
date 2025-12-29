package LibrayManagementSystem;
interface interBookRepo{
    void save(BookEntity book);
    BookEntity findbyid(int id);
    BookEntity updatebook(BookEntity book);
    void deletebook(int id);
    List<BookEntity> findAll();
}
 class BookRepo implements interBookRepo{
    
}
