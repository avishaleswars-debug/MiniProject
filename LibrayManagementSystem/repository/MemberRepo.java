package LibrayManagementSystem.repository;
import java.util.*;
import LibrayManagementSystem.entity.MemberEntity;

public interface InterMemberRepo {
void save(MemberEntity member);
MemberEntity findbyid(int id);
List<MemberEntity> findAll();

void deleteById(MemberEntity member);
    
}
public class MemberRepo implements InterMemberRepo{
    List<MemberEntity> list=new ArrayList<>();
    public void save(MemberEntity member){
list.add(member);
    }
    public MemberEntity findbyid(int id){
        for(MemberEntity arr:list){
            if(id==arr.getmemberID()){
                return arr;
            }
        }
        return null;
    }
    public List<MemberEntity> findAll(){
        return list;
    }
    public void deleteById(MemberEntity member){
        list.remove(member);
    }
}
