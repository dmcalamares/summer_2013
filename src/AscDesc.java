import javax.swing.JOptionPane;


public class AscDesc {
	public static void main (String [] args){
		String numOfInput = JOptionPane.showInputDialog("Number of Inputs:");
		int num=Integer.parseInt(numOfInput);
		String choice = JOptionPane.showInputDialog("A = Ascending \nD = Descending");
		int array [] = new int [num];
		for (int i=0;num>0;num--,i++){
			String x = JOptionPane.showInputDialog("Inputs:");
			int y=Integer.parseInt(x);
			array[i]=y;}
		if (choice.equalsIgnoreCase("A")){
			for(int x=0;x<array.length-1;x++){
				if (array[x]<array[x+1])
					continue;
				else if (array[x]==array[x+1])
					continue;
				else{
					array[x]=array[x+1]+array[x];
					array[x+1]=array[x]-array[x+1];
					array[x]=array[x]-array[x+1];
					x=-1;
				}
			}
			for(int x=0;x<array.length;x++){
				System.out.print(array[x]+" ");
			}
		}
		else if (choice.equalsIgnoreCase("d")){
			for(int x=0;x<array.length-1;x++){
				if (array[x]<array[x+1])
					continue;
				else if (array[x]==array[x+1])
					continue;
				else{
					array[x]=array[x+1]+array[x];
					array[x+1]=array[x]-array[x+1];
					array[x]=array[x]-array[x+1];
					x=-1;
				}
			}
			for(int x=array.length-1;x>=0;x--){
				System.out.print(array[x]+" ");
			}
		}
	}

}
