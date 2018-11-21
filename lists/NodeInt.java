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
	
	public boolean allPositive() {
		if (next==null) { // tail of list is empty
			return data>=0;
		} else {          // tail of list is not empty
			return (data>=0) && next.allPositive();
		}
	}
	
	public boolean allPositive2() {
		boolean result=true;
		NodeInt current = this;
		
		while (current!=null) {
			result = result && (data>=0);
			current = current.next;
		}
		
		return result;
	}
	
	public int size() {
		if (next==null) { // tail of list is empty
			return 1;
		} else {          // tail of list is not empty
			return 1 + next.size();
		}
	}
	
	public int size2() {
		int result=0;
		NodeInt current = this;
		
		while (current!=null) {
			result = result +1;
			current = current.next;
		}
		
		return result;
	}
	
	public NodeInt bump() {
		if (next==null) {
			return new NodeInt(data+1);
		} else {
			return new NodeInt(data+1,next.bump());
		}
	}
	public NodeInt RemoveAdjacent() {
		Integer Current = this.data;
		Integer Next = next.data;
		if(next == null) {
			return new NodeInt(data+1);
		}
		else if(Current == Next) {
			return new NodeInt(Next);
		}
		return new NodeInt(data);
	}
	public NodeInt bump2() {
		NodeInt current = this;
		NodeInt result = new NodeInt(null);
		NodeInt head = result;
		
		while (current!=null) {
			result.next = new NodeInt(current.data+1);
			result=result.next;
			current=current.next;
		}
		
		return head.next;
		
	}
	public static NodeInt difference(NodeInt hd1, NodeInt hd2) {
		NodeInt a = new NodeInt(-1);
		while(hd1 != null && hd2 != null) {
			if (hd1.data == hd2.data) {
				hd1 = hd1.next;
				hd2 = hd2.next;
			} else {
				a.next= hd1;
				return a;
			}
		}
		return a;
	}
	
	public NodeInt filterEven() {
		return null; // implement me!
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
		NodeInt n2 = new NodeInt(1,n1);
		NodeInt n3 = new NodeInt(2,n2);
		n3.RemoveAdjacent();
		NodeInt a1 = new NodeInt(4,n1);
		NodeInt a2 = new NodeInt(3,n3);
		System.out.println(difference(a1,a2));
		
	}
}
