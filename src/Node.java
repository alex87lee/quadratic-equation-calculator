/* Juhyun, Lee
 * mon,wed 8:30 PM - 9:45 PM 
 */

//basic node class.
public class Node {
	public double coef;
	public int exp;
	public Node next;
	
	//cast to make everything null.
	public Node(){
		coef = (Double) null;
		exp = (Integer) null;
		next = null;
	}
	
	//mutation method for parameters
	public Node(double c, int e) {
		coef = c;
		exp = e;
		next = null;
	}
	
	//mutation method for parameters
	public Node(double c, int e, Node n) {
		coef = c;
		exp = e;
		next = n;
	}
	
	//mutation method for parameters
	public Node (Node n){
		coef = n.getCoef();
		exp = n.getExp();
		next = n.getNext();
	}
	
	//get coefficient.
	public double getCoef(){
		return coef;
	}
	
	//get exponent.
	public int getExp(){
		return exp;
	}
	
	//get next node
	public Node getNext(){
		return next;
	}
	public void setCoef(double c){
		coef = c;
	}
	public void setExp(int e){
		exp = e;
	}
	public void setNext(Node nextNode){
		next = nextNode;
	}
}//end of class node
