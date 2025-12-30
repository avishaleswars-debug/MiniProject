package LibrayManagementSystem.entity;

public class BookEntity {
    private int bookid;
    private String title;
    private String Author;
    private boolean isAvailable;
    
    public BookEntity(int bookid,String title,String Author,boolean isAvailable) {
    this.bookid=bookid;
    this.title=title;
    this.Author=Author;
    this.isAvailable=isAvailable;
}
public int getbookid(){
    return bookid;
}
public void setbookid(int bookid){
    this.bookid=bookid;
}
public String  gettitle(){
    return title;
}
public void settitle(String title){
    this.title=title;
}
public String  getAuthor(){
    return Author;
}
public void setAuthor(String Author){
    this.Author=Author;
}
public boolean  getisAvailable(){
    return isAvailable;
}
public void setisAvailable(boolean isAvailable){
    this.isAvailable=isAvailable;
}
public String toString(){
    return " the bookid "+bookid+" title of book "+title+" the book author is "+Author+" and the book availabilty "+isAvailable;
}
}
