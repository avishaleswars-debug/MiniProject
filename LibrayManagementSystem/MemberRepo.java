package LibrayManagementSystem;
 interface InterMemberRepo {
void save(MemberEntity member);
MemberEntity findbyid(int id);
List<MemberEntity> findAll();
void updateMember(MemberEntity member);
void deleteById(int id);
    
}
 public class MemberRepo implements InterMemberRepo{
    
}
