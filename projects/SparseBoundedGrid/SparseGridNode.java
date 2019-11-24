
public class SparseGridNode {

	private Object occupant;
	 private int col;
	 private SparseGridNode next;
	 
	 public SparseGridNode(Object o, int coll,SparseGridNode lnext)
	 {
		occupant = o;
		setCol(coll);
		setNext(lnext);
	 } 
	 
	 public Object getOccupant()
	 {
		 return occupant;
	 }
	 
	 public void setOccupant(Object occ)
	 {
		 occupant = occ;
	 } 

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public SparseGridNode getNext() {
		return next;
	}

	public void setNext(SparseGridNode next) {
		this.next = next;
	} 
}
