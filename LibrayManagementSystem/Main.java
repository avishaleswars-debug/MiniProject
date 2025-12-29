package LibrayManagementSystem;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        //wiring
        InterBookRepo bookrepo=new BookRepo();
        InterMemberRepo memberrepo=new MemberRepo();
        BookService bookservice=new BookService(); 
         AdminMenu am=new AdminMenu();
         MemberMenu mm=new MemberMenu();
        System.out.print("enter your role");
        String role=s.nextLine();
        switch (role) {
            case "admin":
               
                am.adminmenu();
                break;
        case "member":

mm.membermenu();
        break;
          case "exit":
return;
       
            default:
                System.out.println("default input");
                break;
        }

    }
}
