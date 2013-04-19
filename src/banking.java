import javax.swing.JOptionPane;
public class banking{
	public static void main(String []args){
		boolean x = true;
		String fname="",lname="",address="",bday="",bankName=null,description=null,branch=null,location=null;
		int n=0,amount=0,accNo=0;
		linkedList Llist = new linkedList ();
		bankList bList = new bankList();
		bank bankInfo = null,pointer2;
		do{
			try{
		String input = JOptionPane.showInputDialog("Please choose: \n1.Add bank \n2.Add Account("+n+")"+ "\n3.Deposit \n4.Withdraw \n5.Show Accounts \nEnter E to Exit");
		//ADD BANK
		if(input.equals("1")){
			int m=0;
			do{
				bankName=JOptionPane.showInputDialog("Enter Bank's name");
				description=JOptionPane.showInputDialog("Enter Bank's Description");
				branch=JOptionPane.showInputDialog("Enter Bank's branch");
				location=JOptionPane.showInputDialog("Enter banks location");
				int y=0;
				do{
					if(bankName.isEmpty()||description.isEmpty()||branch.isEmpty()||location.isEmpty()){
						JOptionPane.showMessageDialog(null, "Complete required fields");
						y++;
					}
					else{
						
						JOptionPane.showMessageDialog(null,"Bank's Name: "+bankName+"\nBank's Description: "+description+"\nBank's Branch "+
								branch+"\nLocation: "+location);
							bank newBank = new bank(bankName,description,branch,location);
							if(bList.firstBank==null){
								bList.firstBank = bList.lastBank = newBank;
								bList.lastBank.nextBank = null;}
							else if(bList.firstBank==bList.lastBank){
								bList.firstBank.nextBank = bList.lastBank = newBank;
								bList.lastBank.nextBank =null;}
							else{
								bList.lastBank.nextBank=bList.lastBank=newBank;
								bList.lastBank=newBank;
								bList.lastBank.nextBank=null;
								}
							m=1;
							y++;
					}
				}while(y==0);
			}while(m==0);
					}
		//ADD ACCOUNT
		else if(input.equals("2")){
			if(bList.firstBank==null){
				JOptionPane.showMessageDialog(null,"Bank's List is empty");
			}
			else{
				for(bank pointer=bList.firstBank;pointer!=null;pointer=pointer.nextBank){
					JOptionPane.showMessageDialog(null, "Available banks: \nBank Name:"+pointer.bankName1+"\nBank Description:"+pointer.description1+"\nBank Branch:"+pointer.branch1+"\nBank Location:"+pointer.location1);
				}
				int q=0;
				do{
				bankName=JOptionPane.showInputDialog("Enter Bank's name");
				for (pointer2 =bList.firstBank;pointer2!=null;pointer2=pointer2.nextBank){
						if(bankName.isEmpty())
							JOptionPane.showMessageDialog(null, "Enter Bank Name.");
						else if(bankName.equalsIgnoreCase(pointer2.bankName1)){
						 bankInfo = new bank(bankName,description,branch,location);
							q++;
							break;}
				}
			}while(q==0);
			int k=0;
			String accNum;
			do{
				 if(Llist.firstNode==null){
					 accNum= JOptionPane.showInputDialog("Enter desired account number:");
					 accNo=Integer.parseInt(accNum);
					 k++;
				 }
				 else{
					 accNum= JOptionPane.showInputDialog("Enter desired account number:");
					 accNo=Integer.parseInt(accNum);
					 for(list p=Llist.firstNode;p!=null;p=p.nextList){
							if(accNo==p.accNo1){
								JOptionPane.showMessageDialog(null,"Account number not available.");
								k=0;
								break;
							}
							else if (accNo!=p.accNo1){
								k++;
							}
						} 
				 }
				
			}while(k==0);
			fname = JOptionPane.showInputDialog("Enter First Name:");
			lname = JOptionPane.showInputDialog("Enter Last name:");
			address = JOptionPane.showInputDialog("Enter Address:");
			bday = JOptionPane.showInputDialog("Enter Birthday:");
			int h=0;
			do{
				String amnt = JOptionPane.showInputDialog("Enter amount:");
				amount = Integer.parseInt(amnt);

				list newList = new list(accNo,fname,lname,address,bday,amount,bankInfo);
				if(amount<100){
					JOptionPane.showMessageDialog(null,"Deposit must be 100 and above");
					}
				else{
					JOptionPane.showMessageDialog(null,"Account number: "+accNo+"\nName: "+fname+" "+lname+"\nAddress: "+address+"\nBirthday: "+bday+"\nAmount:"+amount+"\nBank's Name:"+
															pointer2.bankName1+"\nBanks Description: "+pointer2.description1+"\nBank's branch: "+pointer2.branch1+"\nBank's location: "+pointer2.location1);
						if(Llist.firstNode==null){
							Llist.firstNode = Llist.lastNode = newList;
							Llist.lastNode.nextList = null;}
						else if(Llist.firstNode==Llist.lastNode){
							Llist.firstNode.nextList = Llist.lastNode = newList;
							Llist.lastNode.nextList =null;}
						else{
							Llist.lastNode.nextList=Llist.lastNode=newList;
							Llist.lastNode=newList;
							Llist.lastNode.nextList=null;
							}
						h++;
						n++;
					}
			}while(h==0);
		}
			int answer = JOptionPane.showConfirmDialog(null, "Perform another transaction?","",JOptionPane.YES_NO_OPTION);
			if(answer==JOptionPane.YES_OPTION){
				continue;
				}
			else{
				System.exit(0);
			}
		}
		//DEPOSIT
		else if(input.equals("3")){
			if(bList.firstBank==null){
				JOptionPane.showMessageDialog(null,"Bank's List is empty");
			}
			else{
					if(Llist.firstNode == null){
						System.out.print("No Account Stored");
					}
					else{
						String accountNo = JOptionPane.showInputDialog("Enter account number");
						int accNumber = Integer.parseInt(accountNo);
							for(list pointer = Llist.firstNode;pointer!=null;pointer=pointer.nextList){
								if(accNumber != pointer.accNo1 && pointer.nextList==null){
									JOptionPane.showMessageDialog(null,"Accout number do not exist.");
									}
								else if(accNumber==pointer.accNo1){
									String val = JOptionPane.showInputDialog("Enter amount:");
									int value = Integer.parseInt(val);
									int sum=value+pointer.amount1;
									pointer.amount1=sum;
									JOptionPane.showMessageDialog(null,"Your new balance is "+sum);
									break;
								}
							}
					}
				}
					int answer = JOptionPane.showConfirmDialog(null, "Perform another transaction?","",JOptionPane.YES_NO_OPTION);
						if(answer==JOptionPane.YES_OPTION){
							continue;}
						else{
							System.exit(0);}
		}
		//WITHDRAW
		else if(input.equals("4")){
			if(bList.firstBank==null){
				JOptionPane.showMessageDialog(null,"Bank's List is empty");
			}
			else{
			if(Llist.firstNode == null){
				System.out.print("No Account Stored");
			}
			else{
				String accountNo = JOptionPane.showInputDialog("Enter account number");
				int accNumber = Integer.parseInt(accountNo);
					for(list pointer = Llist.firstNode;pointer!=null;pointer=pointer.nextList){
						if(accNumber == pointer.accNo1){
							String val = JOptionPane.showInputDialog("Enter amount:");
							int value = Integer.parseInt(val);
							int diff=pointer.amount1-value;
							pointer.amount1=diff;
							if(diff<100)
								JOptionPane.showMessageDialog(null,"Transaction Failed. Below Maintaining balance");
							else{
								JOptionPane.showMessageDialog(null,"Your new balance is "+diff);
							break;}
							}
						else if(accNumber!=pointer.accNo1 && pointer.nextList==null){
							JOptionPane.showMessageDialog(null,"Accout number do not exist.");
							}
						}
			}
			}
				int answer = JOptionPane.showConfirmDialog(null, "Perform another transaction?","",JOptionPane.YES_NO_OPTION);
					if(answer==JOptionPane.YES_OPTION)
						continue;
					else
						System.exit(0);
		}
		//PRINT
		else if(input.equals("5")){
			if(Llist.firstNode==null){
				JOptionPane.showMessageDialog(null, "List is empty");
			}
			else{
				String display="";
				for(list pointer=Llist.firstNode;pointer!=null;pointer=pointer.nextList){
					display = display +"Account No: "+pointer.accNo1+"\nName: "+" "+pointer.fname1+" "+pointer.lname1+"\nAddress: "+pointer.address1+"\nBirthday: "+pointer.bday1+"\nBalance: "+pointer.amount1+
							"\nBank's Name: "+bankName+"\nBank's Description: "+description+"\nBank's Branch: "+branch+"\nBank's Location: "+location;
					JOptionPane.showMessageDialog(null,display);
					display="";
				}
				}
			int answer = JOptionPane.showConfirmDialog(null, "Perform another transaction?","",JOptionPane.YES_NO_OPTION);
			if(answer==JOptionPane.YES_OPTION)
				continue;
			else
				System.exit(0);
		}
		//EXIT
		else if(input.equalsIgnoreCase("E")){
			System.exit(0);
		}
		else{
			JOptionPane.showMessageDialog(null, "Invalid Command!");
			int answer = JOptionPane.showConfirmDialog(null, "Perform another transaction?","",JOptionPane.YES_NO_OPTION);
			if(answer==JOptionPane.YES_OPTION)
				continue;
			else
				System.exit(0);
		}
			}catch(Throwable d){
				JOptionPane.showMessageDialog(null,"Error! Please try agan and double check your entry.");
			}
	}while(x==true);
}
}
