package LibrayManagementSystem.service;

import java.util.List;
import LibrayManagementSystem.entity.BookEntity;
import LibrayManagementSystem.entity.BorrowEntity;
import LibrayManagementSystem.entity.BorrowStatus;
import LibrayManagementSystem.entity.MemberEntity;
import LibrayManagementSystem.repository.interBookRepo;
import LibrayManagementSystem.repository.InterMemberRepo;
import LibrayManagementSystem.repository.interBorrowBook;

public class BorrorService implements IBorrowService {
    private interBookRepo bookrepo;
    private InterMemberRepo member;
    private interBorrowBook borrorrepo;
    
    public BorrorService(interBookRepo bookrepo,InterMemberRepo member, interBorrowBook borrorrepo){
        this.bookrepo=bookrepo;
        this.member=member;
        this.borrorrepo=borrorrepo;
    }

    public boolean issuebook(BorrowEntity borrow){
        BookEntity book=bookrepo.findbyid(borrow.getBookId());
        MemberEntity mem=member.findbyid(borrow.getMemberId());
        
        if(book==null || mem==null){
            return false;
        }
        
        if(!book.getisAvailable()){
            return false;
        }
        
        borrorrepo.save(borrow);
        book.setisAvailable(false);
        mem.setBorrowed(mem.getborrowed() + 1);
        return true;
    }
    
    public boolean returnbook(int bookId, int memberId){
        BookEntity book=bookrepo.findbyid(bookId);
        MemberEntity mem=member.findbyid(memberId);
        
        if(book==null || mem==null){
            return false;
        }
        
        List<BorrowEntity> borrows = borrorrepo.filterbymemberid(memberId);
        for(BorrowEntity b : borrows){
            if(b.getBookId() == bookId && b.getStatus() == BorrowStatus.BORROWED){
                b.returnBook();
                book.setisAvailable(true);
                if(mem.getborrowed() > 0){
                    mem.setBorrowed(mem.getborrowed() - 1);
                }
                return true;
            }
        }
        return false;
    }
    
    // Overloaded method for backward compatibility
    public boolean returnbook(BorrowEntity borrow){
        return returnbook(borrow.getBookId(), borrow.getMemberId());
    }
    
    public List<BorrowEntity> getBorrowsByMemberId(int memberId){
        return borrorrepo.filterbymemberid(memberId);
    }
    
    public List<BorrowEntity> getBorrowsByBookId(int bookId){
        return borrorrepo.filterbybookid(bookId);
    }
    
    public List<BorrowEntity> getAllBorrows(){
        return borrorrepo.findAll();
    }
}
