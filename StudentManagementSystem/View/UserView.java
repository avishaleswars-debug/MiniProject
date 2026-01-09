package StudentManagementSystem.View;
import java.util.*;
import StudentManagementSystem.Entity.User;
public class UserView {
    private static Scanner sc=new Scanner(System.in);
    public int menu(){
        System.out.println("""
                1.add students
                2.view students
                """);
                return sc.nextInt();
    }
    public int id(){
        System.out.println("enter the id");
        return sc.nextInt();
    }
    public String name(){
        System.out.println("enter the name");
        return sc.nextLine();
    }
    public int age(){
        System.out.println("enter the age");
        return sc.nextInt();
    }
    public void display(List<User> list){
        list.forEach(s->
            System.out.println(s.getid()+"  |  "+s.getname()+"  |  "+s.getage())
        );
    }
}
