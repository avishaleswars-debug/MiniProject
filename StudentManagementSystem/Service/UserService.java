package StudentManagementSystem.Service;

import java.util.List;
import StudentManagementSystem.Entity.User;

import StudentManagementSystem.Repository.Repo;

public class UserService implements IUserService {
    private Repo repo;
  public  UserService(Repo repo){
        this.repo=repo;
    }
   public    List<User> serviceRead() throws Exception{
return repo.read();
      }
public void createUserService(int id,String name,int age)throws Exception{
repo.create(new User(id,name,age));
}
}
