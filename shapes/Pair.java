package shapes;

public class Pair<E,F> {
	private E fst;
	private F snd;
	
	Pair(E fst, F snd){
		this.fst=fst;
		this.snd=snd;
	}
	
	public E getFst() {
		return fst;
	}
	
	public F getSnd() {
		return snd;
	}
	
	public void setFst(E fst) {
		this.fst=fst;
	}
	
	public String toString() {
		return "("+fst+","+snd+")";
	}

}
