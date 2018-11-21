package Recitation;

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


    public static NodeInt take(int n, NodeInt start) {
      if (n == 0) {
        return start;
      }
      NodeInt hd = start;
      for (int i = 1; i<n; i++, start=start.next);
      start.next = null;
      return hd;
    }

    public static NodeInt filterEvens(NodeInt start) {
      NodeInt dummy = new NodeInt(2);
      NodeInt hd = dummy;
      while(start != null) {
        if (start.data % 2 == 1) {
          dummy.next = start;
          dummy = dummy.next;
        }
        start = start.next;
      }
      dummy.next = null;
      return hd.next;
    }

    public static NodeInt drop(int n, NodeInt start) {
      if (n == 0) {
        return start;
      }
      int len = 0;
      NodeInt curr = start;
      for ( ; curr != null; curr=curr.next, len++);
      for (int i = 0; i<len-n; i++, start=start.next);
      return start;
    }
    public boolean allEven() {
      if (this.next == null) {
        return this.data % 2 == 0;
      }
      return (this.data % 2 == 0) && this.next.allEven();
	  }

    public static NodeInt repeat(int n, Integer z) {
      if (n == 0) {
        return null;
      }
      NodeInt output = new NodeInt(z, repeat(n-1, z));
      return output;
    }

    public static NodeInt stutter(int n) {
      NodeInt curr = this.data;
      NodeInt head = curr;
      while(curr != null) {
        NodeInt currNext = curr.next;
        curr.next = repeat(n-1, curr.data);
        curr = curr.next;
        while (curr.next != null) {
          curr = curr.next;
        }
        curr.next = currNext;
        curr = currNext;
      }
      return head;
    }
    public static NodeInt doubleL(NodeInt Node) {
    	if(Node.next == null) {
    		Node.data = (Node.data * 2);
    		return new NodeInt(Node.data);
    	} else {
    		Node.data = (Node.data * 2);
    		return new NodeInt(Node.data, doubleL(Node.next));
    	}
       	
    }
    public NodeInt<E> append(NodeInt<E> Node1, NodeInt<E> Node2) {
    	if(Node1 == null) {
    		return Node2;
    	}
    	if(Node2 == null) {
    		return Node1;
    	}
    	else {
    		NodeInt<E> temp = Node1;
    		while(temp.next != null) {
    			temp = temp.next;
    		}
    		while(Node2.next != null) {
    			temp.data = Node2.data;
    			Node2 = Node2.next;
    			temp = temp.next;
    		}
    		return temp;
    	}
    }
    public String toString() {
    	if (next==null) {
    	    return data.toString();
    	} else {
    	    return data.toString() + "," + next.toString();
    	}
    }

    public static void main(String[]  args) {
	NodeInt n1 = new NodeInt(2);
	NodeInt n2 = new NodeInt(3, n1);
	NodeInt n3 = new NodeInt(4,n2);
	System.out.println(doubleL(n3));
    }
}
