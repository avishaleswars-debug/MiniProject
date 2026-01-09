package StudentManagementSystem.Main;
import StudentManagementSystem.Controller.UserController;
import StudentManagementSystem.Service.UserService;
import StudentManagementSystem.View.UserView;
import StudentManagementSystem.Repository.IRepo;
import StudentManagementSystem.Repository.Repo;
import StudentManagementSystem.Service.IUserService;

public class Main {
public static void main(String[] args) {
IRepo repo=new Repo();
    IUserService service =new UserService(repo);
UserView view =new UserView();
    UserController control=new UserController(view,service);
    control.begin();
}
}
