package lists;

public class NodeInt {
    // Data fields
    private Integer data;
    private NodeInt next;
	
    // Constructors
    NodeInt(Integer data) {
	this.data=data;
	this.next=null;
    }
    NodeInt(Integer data, NodeInt next) {
	this.data=data;
	this.next=next;
    }
	

    
    public boolean allEven() {
	\\ Implement me!
	    }
    public NodeInt stutter() {
	\\ Implement me!
	    }
    public String toString() {
	if (next==null) {
	    return data.toString();
	} else {
	    return data.toString() + "," + next.toString();
	}
    }
    
    public static void main(String[]  args) {
	NodeInt n1 = new NodeInt(1);
	NodeInt n2 = new NodeInt(2,n1);
	NodeInt n3 = new NodeInt(3,n2);
		
	System.out.println(n3.allEven());
	System.out.println(n3);
	System.out.println(n3.stutter());
    }
}
