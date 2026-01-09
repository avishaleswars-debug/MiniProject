package StudentManagementSystem.Main;
//import StudentManagementSystem.Repository.IRepo;
import StudentManagementSystem.Repository.Repo;
//import StudentManagementSystem.Service.IUserService;
import StudentManagementSystem.Service.UserService;
import StudentManagementSystem.View.UserView;
import StudentManagementSystem.Controller.UserController;

public class Main {
public static void main(String[] args) {
//IRepo repo=;
  //  IUserService service =);
UserView view =new UserView();
    UserController control=new UserController(view,new UserService(new Repo()));
    control.begin();
}
}
