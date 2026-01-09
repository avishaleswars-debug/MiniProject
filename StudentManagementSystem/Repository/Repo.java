package StudentManagementSystem.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import StudentManagementSystem.DBConnection.DBConnection;


import StudentManagementSystem.Entity.User;
import java.util.*;
public class Repo implements IRepo{

  public void create(User user) {
    try{
String sql="insert into students(id,name,age) values(?,?,?)";
Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement(sql);
ps.setInt(1, user.getid());
ps.setString(2, user.getname());
ps.setInt(3, user.getage());
ps.executeUpdate();

    }
    catch(Exception e){
        System.out.println("error appeared");
    }

  }

  
   public  List<User> read() throws Exception {
    ArrayList<User> list=new ArrayList<>();
String sql="select * from students";
Connection con=DBConnection.getConnection();
PreparedStatement ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
while (rs.next()) {
    list.add(new User(rs.getInt("id"),rs.getString("name"),rs.getInt("age")));
}
return list;
   }
   public  void update(User user){

   }
   public  void delete(User user){
    
   }
}
