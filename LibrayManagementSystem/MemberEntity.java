 class MemberEntity {
    private int MemberID;
private String name;
private int borrowed;
MemberEntity(int MemberID,String name,int borrowed){
    this.MemberID=MemberID;
    this.name=name;
    this.borrowed=borrowed;
}
public void setmemberID(int MemberID){
    this.MemberID=MemberID;
}
public int getmemberID(){
    return MemberID;
}
public void setBorrowed(int borrowed){
    this.borrowed=borrowed;
}
public int getborrowed(){
    return borrowed;
}
public void setname(String name){
    this.name=name;
}
public String getname(){
    return name;
}
}
