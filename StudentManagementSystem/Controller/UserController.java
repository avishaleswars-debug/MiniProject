package StudentManagementSystem.Controller;
import StudentManagementSystem.Service.UserService;

import StudentManagementSystem.View.UserView;
public class UserController {
    private UserView view;
    private UserService service;
   public UserController(UserView view,UserService service){
this.view=view;
this.service=service;
    }
    public void begin(){
        while(true) {
int choice =view.menu();
switch (choice) {
    case 1:
      int id=  view.id();
        String name= view.name();
        int age= view.age();
        service.createUserService(id,name,age);
        break;
case 2:
view.display(service.serviceRead());
break;
    default:
        System.out.println("default");
        break;
}
        }
    }
}
