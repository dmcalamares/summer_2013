import javax.swing.JOptionPane;


public class Reverse {
	public static void main(String [] args){
		String input = "";
		input =JOptionPane.showInputDialog("Enter a word");
		int len= input.length();
		for(int i=len;i!=0;i--){
		System.out.print(input.charAt(i-1));
	}
		}

}
