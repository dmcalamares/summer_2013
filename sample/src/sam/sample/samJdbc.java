package sam.sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/*This code connects to the mysql database*/
public class samJdbc 
{
    public Connection con = null;
    public Statement statement= null;
    public String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public String username = "root",password = "";
    static String dbname = "jdbc:mysql://localhost/sample?user=root";
    String sql="select * from item",sqlAdd="",sqlUpdate="";
    String dbtime,dbtname="";
    String dbtime2;
    String dbtime3;
    String dbtime4;
    String dbtime5;


    public static void main( String args[] )
    {
    	int v=0;
    	do{
    	String input=JOptionPane.showInputDialog("1.View Item\n2.Add Item \n3.Update \n4.Delete");
    	int choice=Integer.parseInt(input);
        
        if(choice==1){
        	samJdbc sam = new samJdbc();
        	sam.view();
        }
        else if(choice==2){
        	samJdbc sam= new samJdbc();
        	sam.add();
        	sam.view();
        }
        else if(choice==3){
        	samJdbc sam =new samJdbc();
        	sam.update();
        	sam.view();
        }
        else if(choice==4){
        	samJdbc sam =new samJdbc();
        	sam.delete();
        	sam.view();
        }
        else{
        	JOptionPane.showMessageDialog(null,"Invalid Commnand");
        }
    }while(v==0);
        
        
    }
    public void view(){
    	try{
    		Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
    	ResultSet r=statement.executeQuery(sql);
    	while(r.next()){
    		dbtime=r.getString(1);
    		dbtime2=r.getString(2);
    		dbtime3=r.getString(3);
    		dbtime4=r.getString(4);
    		dbtime5=r.getString(5);
    		dbtname=dbtname +"\n"+(dbtime+"|"+dbtime2+"|"+dbtime3+"|"+dbtime4+"|"+dbtime5);
    			}JOptionPane.showMessageDialog(null, dbtname);
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null,"Error!");
    	}
    }
    public void add(){
    	try{
    		Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            String a1=JOptionPane.showInputDialog("Enter item name");
            String a2=JOptionPane.showInputDialog("Enter item description");
            String a3=JOptionPane.showInputDialog("Enter item price");
            String a4=JOptionPane.showInputDialog("Enter item quantity");
            sqlAdd="INSERT into item (name,description,price,qty)values('"+a1+"','"+a2+"',"+a3+","+a4+")";
            statement.execute(sqlAdd);
            
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null, "Error!!");
    	}
    }
    public void update(){
    	try{
    		Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            String a1=JOptionPane.showInputDialog("Enter item id");
            int a2=Integer.parseInt(a1);
            String prop=JOptionPane.showInputDialog("What do you want to change? \n>name \n>description \n>price \n>qty");
            String newValue=JOptionPane.showInputDialog("Enter new value");
            sqlUpdate="update item set "+prop+" = '"+newValue+"'where item.id="+a2+"";
            statement.execute(sqlUpdate);
            
    	}catch (Exception e){
    		JOptionPane.showMessageDialog(null, "Error!!");
    	}
    }
    public void delete(){
    	try{
    		Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(dbname,username,password);
            statement= con.createStatement();
            String a1=JOptionPane.showInputDialog("Enter the id number of item you wish to delete");
            int a2=Integer.parseInt(a1);
            sqlUpdate="delete from item where item.id="+a2+"";
            statement.execute(sqlUpdate);
    		
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null,"Error!!!");
    	}
    }
}
