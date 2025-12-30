package LibrayManagementSystem.service;

import java.util.List;
import LibrayManagementSystem.entity.MemberEntity;
import LibrayManagementSystem.repository.InterMemberRepo;

public class MemberService implements IMemberService {
    private InterMemberRepo memberrepo;
    
    public MemberService(InterMemberRepo memberrepo){
        this.memberrepo=memberrepo;
    }
    
    public void addMember(MemberEntity member){
        memberrepo.save(member);
    }
    
    public List<MemberEntity> viewmember(){
        return memberrepo.findAll();
    }
    
    public MemberEntity findMemberById(int id){
        return memberrepo.findbyid(id);
    }
    
    public List<MemberEntity> filterMembersByName(String name){
        List<MemberEntity> allMembers = memberrepo.findAll();
        List<MemberEntity> filteredMembers = new java.util.ArrayList<>();
        for(MemberEntity member : allMembers){
            if(member.getname().toLowerCase().contains(name.toLowerCase())){
                filteredMembers.add(member);
            }
        }
        return filteredMembers;
    }
    
    public boolean removeMember(int id){
        MemberEntity member = memberrepo.findbyid(id);
        if(member != null){
            memberrepo.deleteById(member);
            return true;
        }
        return false;
    }
}
