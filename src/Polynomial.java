/* Juhyun, Lee
 * Csci-313
 * mon,wed 8:30 PM - 9:45 PM 
 */

import java.util.LinkedList;

//Polynomial class which extends linked list.
public class Polynomial extends LinkedList {

	private Node first = null;
	private Node last = first;
	
	public Node getFirst(){
		return first;
	}
	
	/*
	 * insert method which will sort the incoming node so there is no need
	 * for later sorting.
	 */
	public void Insert (double coef, int exp, Polynomial impor){
	    Node temp = new Node(coef, exp, null);
	    first = impor.getFirst();
	    if (first == null){
	        first = temp;
	    }
	    else {
	        Node p = null;
	        Node q = first;
	        while(q!= null){
	        	if (temp.getExp() > q.getExp()){
		        	temp.setNext(first);
		        	first = temp;
		        	break;
		        }
	        	else if (temp.getExp() == q.getExp()){
	        		q.setCoef(temp.getCoef() + q.getCoef());
	        		if(q.getCoef() == 0 && q.getNext() == null){
	        			q.setCoef(0);
	        			q.setExp(0);
	        		}
	        		else if ( q.getCoef() == 0)
	        			p.setNext(q.getNext());
	        		break;
	        	}
	        	else if (temp.getExp() < q.getExp() && q.getNext() == null){
	        		q.setNext(temp);
	        		temp.setNext(null);
	        		last = temp;
	        		break;
	        	}
	        	else if (temp.getExp() < q.getExp() && temp.getExp() > q.getNext().getCoef()){	
	        		temp.setNext(q.getNext());
	        		q.setNext(temp);
	        		break;
	    		}
        		p = q;
        		q = q.getNext();
	        	
	        }
	    }
	}//end of insert.
	
	//addition method for polynomials.
	public Polynomial addPoly (Polynomial p1, Polynomial p2){
		Polynomial temp = new Polynomial();
		
		if( p1.getFirst() == null || p2.getFirst() == null
				|| p1 == null || p2 == null){
			return null;
		}
		temp = temp.copyList(p1);
		Node p2curr = p2.getFirst();
		while(p2curr != null){
			temp.Insert( p2curr.getCoef() , p2curr.getExp(), temp);
			p2curr = p2curr.getNext();
		}
		return temp;
			
	}//end of addition
	
	//subtraction method for polynomials.
	public Polynomial subPoly (Polynomial p1, Polynomial p2){
		Polynomial temp = new Polynomial();
		
		if( p1.getFirst() == null || p2.getFirst() == null
				|| p1 == null || p2 == null){
			return null;
		}
		temp = temp.copyList(p1);
		Node p2curr = p2.getFirst();
		while(p2curr != null){
			temp.Insert( -1*p2curr.getCoef() , p2curr.getExp(), temp);
			p2curr = p2curr.getNext();
		}
		return temp;
			
	}//end of subtration.
	
	//multiply method for polynomials.
	public Polynomial multPoly (Polynomial p1, Polynomial p2){
		Polynomial temp = new Polynomial();
		if( p1.getFirst() == null || p2.getFirst() == null){
			return null;
		}
		Node p1curr = p1.getFirst();
		Node p2curr = p2.getFirst();
		
		while(p1curr != null){
			while(p2curr != null){
				temp.Insert(p1curr.getCoef()*p2curr.getCoef(), p1curr.getExp()+p2curr.getExp(), temp);
				p2curr = p2curr.getNext();
			}
			p1curr = p1curr.getNext();
			p2curr = p2.getFirst();
		}
		return temp;		
	}//end of multiply.
	
	//derivative method for single polynomial.
	public Polynomial derPoly (Polynomial p1){
		Polynomial temp = new Polynomial();
		if( p1.getFirst() == null)
			return null;
		Node p1curr = p1.getFirst();
		while(p1curr != null){
			if(p1curr.getExp()-1 <= 0){
				temp.Insert(0, 0, temp);
				return temp;
			}
			temp.Insert(p1curr.getExp()*p1curr.getCoef() , p1curr.getExp()-1, temp);
			p1curr = p1curr.getNext();
		}
			return temp;
	}//end of derivative.
	
	//evaluation method for single polynomial.
	public double evalPoly (Polynomial p1, int x){
		double total = 0;
		if( p1.getFirst() == null)
			return (Double) null;
		else{
			Node p1curr = p1.getFirst();
			while(p1curr != null){
				total = total + (p1curr.getCoef()*Math.pow(x, p1curr.getExp())); 
				p1curr = p1curr.getNext();
			}
		return total;
		}	
	}//end of evaluation.
	
	//custom written clone method to clone polynomial object.
	public Polynomial copyList(Polynomial orig){
		Polynomial temp = new Polynomial();
		Node star = orig.getFirst();
		Node dupnode = new Node();

		
		dupnode.setCoef(star.getCoef());
		dupnode.setExp(star.getExp());
		temp.first = dupnode;
		star = star.getNext();
		
		while(star != null){
			Node dupnode2 = new Node();
			dupnode2.setCoef(star.getCoef());
			dupnode2.setExp(star.getExp());
			
			dupnode.setNext(dupnode2);
			star = star.getNext();
			dupnode = dupnode.getNext();
		}
		return temp;
	}

}//end of polunomial calss.
