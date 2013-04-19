public class list {
	public int accNo1;
	public String fname1;
	public String lname1;
	public String address1;
	public String bday1;
	public int amount1;
	public bank bankInfo1;
	
	public list nextList;
	public list (int accNo,String fname,String lname,String address,String bday,int amount,bank bankInfo){
		accNo1=accNo;
		fname1=fname;
		lname1=lname;
		address1=address;
		bday1=bday;
		amount1=amount;
		bankInfo1=bankInfo;
	}
	
}