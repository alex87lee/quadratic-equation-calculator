/* Juhyun, Lee
 * Csci-313
 * mon,wed 8:30 PM - 9:45 PM 
 */

import javax.swing.JOptionPane;

/*
 * driver class with no other method than print, store, handle UI.
 * collection array will collect the data from user until program termination.
 */
public class Project2 {

	public static Polynomial[] collection = new Polynomial[10];
	
	
	/*
	 * storepoly will store the data to array collection 
	 * also insure and expands the array if the room is small
	 */
	public static void StorePoly (Polynomial poly){
		for( int i = 0; i < collection.length; i++){
			if( i == collection.length-1 && collection[i] != null){
				Polynomial[] newCollection = new Polynomial[i*i];
				System.arraycopy(collection, 0, newCollection, 0, i);
				collection = newCollection;
			}
				
			if( collection[i] == null )
				collection[i] = poly;
		}
	}
	/*
	 * mutated method for Placement store.
	 */
	public static void storePoly(int x, Polynomial poly){
		collection[x] = poly;
	}

	/*
	 * takes in single polynomial class and turn it in to printable string buffer.
	 */
	public static StringBuffer printPoly(Polynomial temp){
		StringBuffer nomial = new StringBuffer();
		Node curr = temp.getFirst();
		while(curr != null){
			if(curr.getExp() == 0 ){
				if( curr.getCoef() > 0 )
					nomial.append("+" + curr.getCoef()+ " ");
				else
					nomial.append(curr.getCoef()+ " ");
			}
			else{
				if( curr.getCoef() > 0 )
					nomial.append("+" + curr.getCoef() + "x^" + curr.getExp() + " ");
				else
					nomial.append(curr.getCoef() + "x^" + curr.getExp() + " ");
			}
		curr = curr.getNext();
		}
		return nomial;
	}
	
	/*
	 * takes the whole array and buffer them in to single string to print on screen.
	 */
	public static StringBuffer printPolyAll(){
		StringBuffer nomial = new StringBuffer();
		int i = 0;
		if(collection[0] == null){
			nomial.append("current list is empty \n" + "**enter any button to go back to menu** \n");
			return nomial;
		}
		else{
			while(collection[i] != null){
				nomial.append(Integer.toString(i) + " >>>> ");
				Node curr = collection[i].getFirst();
				
				while(curr != null){
					if(curr.getExp() == 0 ){
						if( curr.getCoef() > 0 )
							nomial.append("+" + curr.getCoef()+ " ");
						else
							nomial.append(curr.getCoef()+ " ");
					}
					else{
						if( curr.getCoef() > 0 )
							nomial.append("+" + curr.getCoef() + " x^" + curr.getExp() + " ");
						else
							nomial.append(curr.getCoef() + " x^" + curr.getExp() + " ");
					}
				curr = curr.getNext();
				}

			i++;
			nomial.append("\n");
			}
			nomial.append(Integer.toString(i) + " >>>>  EMPTY \n" );
			return nomial;
		}
	}	
	/*
	 * method to add any result of add,sub,mult,derive.
	 */
	public static void addtoarr(Polynomial poly){
		int i = 0;
		while(collection[i] != null){
			i++;
		}
		collection[i] = poly;
	}
	/*
	 * main
	 */
	public static void main(String[] args) {
	//start label to come back from bad input.
	start:
		while(true){  //loop til user terminates the program.
			String input = JOptionPane.showInputDialog(null, "TYPE \n i to input " +
					"\n p to Print all polynomial \n a to add " +
					"\n s to subtract \n m to multiply " +
					"\n d to derive \n e to Evaluate." +
					"\n **exit to terminate program.**");
			if(input == null)
				System.exit(0);
			input.toLowerCase();
	//try to catch none int/ double input.		
	try{		
			//insert or input polynomial.
			if(input.equals("i")){ 
				Polynomial poly = new Polynomial();
				String ans;
				double incoe; int inexp; int choice = -1;
				String numb = JOptionPane.showInputDialog(null, printPolyAll().toString() + "\n choose polynomial by the number in front."
						+ "\n type '0' to add if no polynomial exist!"
						+ "\n to input new polynomial correctly choose empty ");

					choice = Integer.parseInt(numb);
					ans = JOptionPane.showInputDialog(null, "input coefficient");
					incoe = Integer.parseInt(ans);
					if(incoe == 0){
						JOptionPane.showMessageDialog(null, "coefficient 0 will result in zero term. \n please enter other value then 0");
						continue start;
					}
					ans = JOptionPane.showInputDialog(null, "input exponent");
					inexp = Integer.parseInt(ans);
					if(inexp < 0){
						JOptionPane.showMessageDialog(null, "exponent lower then 0 is not valid. \n please enter other value");
						continue start;
					}
					if(choice <= -1){
						JOptionPane.showMessageDialog(null, "not a Valid Choice!!");
						continue start;
					}
					else{ 
						if( collection[choice] == null){
							Polynomial assi = new Polynomial();
							collection[choice] = assi;
						}
						poly.Insert(incoe, inexp, collection[choice]);
						collection[choice] = poly;
						storePoly(choice, poly);

					}

			}	
			//print polynomials
			else if(input.equals("p")) 
				JOptionPane.showMessageDialog(null,  printPolyAll().toString());
			//add polynomials
			else if(input.equals("a")){
				Polynomial answ = new Polynomial();

					String choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"ADDITION" + "\n Choose 1st polynomial");
					int pol1 = Integer.parseInt(choos);
					if(collection[pol1] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"ADDITION" + "\n Choose 2st polynomial");
					int pol2 = Integer.parseInt(choos);
					if(collection[pol2] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					answ = answ.addPoly(collection[pol1],collection[pol2]);
					
					JOptionPane.showMessageDialog(null, "Answer is " + printPoly(answ));
					addtoarr(answ);

				
			}
			//subtract polynomials.	
			else if(input.equals("s")){
				Polynomial answ = new Polynomial();

					String choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"SUBTRACTION" + "\n Choose 1st polynomial");
					int pol1 = Integer.parseInt(choos);
					if(collection[pol1] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"SUBTRACTION" + "\n Choose 2st polynomial");
					int pol2 = Integer.parseInt(choos);
					if(collection[pol2] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					answ = answ.subPoly(collection[pol1],collection[pol2]);
					
					JOptionPane.showMessageDialog(null, "Answer is " + printPoly(answ));
					addtoarr(answ);

				
			}
			//multiply polynomials.
			else if(input.equals("m")){
				Polynomial answ = new Polynomial();

					String choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"MULTIPLY" + "\n Choose 1st polynomial");
					int pol1 = Integer.parseInt(choos);					
					if(collection[pol1] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"MULTIPLY" + "\n Choose 2st polynomial");
					int pol2 = Integer.parseInt(choos);
					if(collection[pol2] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					answ = answ.multPoly(collection[pol1],collection[pol2]);
					
					JOptionPane.showMessageDialog(null, "Answer is " + printPoly(answ));
					addtoarr(answ);

				
			
			}
			//derivative polynomials.
			else if(input.equals("d")){
				Polynomial answ = new Polynomial();

					String choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"DERIVE" + "\n Choose 1st polynomial");
					int pol1 = Integer.parseInt(choos);					
					if(collection[pol1] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					answ = answ.derPoly(collection[pol1]);
					
					JOptionPane.showMessageDialog(null, "Answer is " + printPoly(answ));
					addtoarr(answ);

			}
			//evaluate polynomials.
			else if(input.equals("e")){
				Polynomial answ = new Polynomial();
				double evalan ;

					String choos = JOptionPane.showInputDialog(null, printPolyAll().toString() +"Evaluate" + "\n Choose polynomial");
					int pol1 = Integer.parseInt(choos);
					if(collection[pol1] == null){
						JOptionPane.showMessageDialog(null, "Polynomial you have chosen is empty");
						continue start;
					}
					choos = JOptionPane.showInputDialog(null, "Evaluate" + "\n Choose x value \n ***MUST BE AN INTEGER***");
					if(choos == null){
						JOptionPane.showMessageDialog(null, "Wrong value of X");
						continue start;
					}
					int x = Integer.parseInt(choos);
					evalan = answ.evalPoly(collection[pol1], x);
					
					JOptionPane.showMessageDialog(null, "Answer is " + evalan);

			}
			//exit on command.
			else if( input == null || input.equals("exit") )
					System.exit(0); //exits program.
			//anything else consider as invalid input.
			else{
				JOptionPane.showMessageDialog(null, "invalid Input");
			
			}
		}
	//catch bad non double or integer input.
	catch(NumberFormatException nFE){
		JOptionPane.showMessageDialog(null, "not a Valid Choice!!");
		continue;
	}
	}
	
	}//end of main.
}//end of program.
