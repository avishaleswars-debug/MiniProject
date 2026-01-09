package StudentManagementSystem.Repository;
import java.util.*;
import StudentManagementSystem.Entity.User;
public interface IRepo {
    void create(User user);
    List<User> read() throws Exception;
    void update(User user);
    void delete(User user);
}
