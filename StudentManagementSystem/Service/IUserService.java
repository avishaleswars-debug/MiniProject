package StudentManagementSystem.Service;
import StudentManagementSystem.Entity.User;
import java.util.*;
public interface IUserService {
    List<User> serviceRead() throws Exception;
void createUserService(int id,String name,int age)throws Exception;
}
