package StudentManagementSystem.Entity;

public class User {
    private int id;
    private String name;
    private int age;
public User(int id,String name,int age){
    this.id=id;
    this.name=name;
    this.age=age;
}
public void setname(String name){
this.name=name;
}
public void setid(int id){
this.id=id;
}
public void setage(int age){
this.age=age;
}
public String getname(){
    return name;
}
public int getid(){
    return id;

}
public int getage(){
    return age;
}

}
