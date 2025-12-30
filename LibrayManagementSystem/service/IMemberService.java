package LibrayManagementSystem.service;

import java.util.List;
import LibrayManagementSystem.entity.MemberEntity;

public interface IMemberService {
    void addMember(MemberEntity member);
    List<MemberEntity> viewmember();
    MemberEntity findMemberById(int id);
    List<MemberEntity> filterMembersByName(String name);
    boolean removeMember(int id);
}

