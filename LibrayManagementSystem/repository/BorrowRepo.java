package LibrayManagementSystem.repository;

import java.util.*;
import LibrayManagementSystem.entity.BorrowEntity;

public interface interBorrowBook{
    void save(BorrowEntity borrow);
    List<BorrowEntity> findAll();
    List<BorrowEntity> filterbybookid(int id);
    List<BorrowEntity> filterbymemberid(int id);
}
public class BorrowRepo implements interBorrowBook {
    private List<BorrowEntity> list = new ArrayList<>();
    
    public void save(BorrowEntity borrow){
        list.add(borrow);
    }
    
    public List<BorrowEntity> findAll(){
        return new ArrayList<>(list); // Return a copy to prevent external modification
    }
    
    public List<BorrowEntity> filterbybookid(int id){
        List<BorrowEntity> filteredList = new ArrayList<>();
        for(BorrowEntity borrow : list){
            if(id == borrow.getBookId()){
                filteredList.add(borrow);
            }
        }
        return filteredList;
    }
    
    public List<BorrowEntity> filterbymemberid(int id){
        List<BorrowEntity> filteredList = new ArrayList<>();
        for(BorrowEntity borrow : list){
            if(id == borrow.getMemberId()){
                filteredList.add(borrow);
            }
        }
        return filteredList;
    }
}
