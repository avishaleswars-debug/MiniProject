package LibrayManagementSystem;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("enter your role");
        String role=s.nextLine();
        switch (role) {
            case "admin":
                AdminMenu am=new AdminMenu();
                am.adminmenu();
                break;
        case "member":
MemberMenu mm=new MemberMenu();
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
