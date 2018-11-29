import java.util.*;
public class PercolationBFS extends PercolationDFSFast {

	public PercolationBFS(int n) {
		super(n);
		
	}
	
	public int getIndex(int row, int col) {

		return (row * myGrid.length + col);
		
	}
	
	
	@Override
	protected void dfs(int row, int col) {
		if (! inBounds(row,col)) return;
		
		if (isFull(row, col) || !isOpen(row, col))
			return;
		
		Queue<Integer> qp = new LinkedList<>();
		int size = myGrid.length;
		myGrid[row][col]=FULL;
//		size++;
		qp.add(getIndex(row,col));
		while (qp.size()!= 0) {
			Integer value = qp.remove();
			int qrow = value/size;
			int qcol = value%size;
			
			if (inBounds (qrow+1, qcol) && isOpen(qrow+1,qcol) && ! isFull(qrow+1,qcol)) {
				myGrid[qrow+1][qcol] = FULL;
				qp.add(getIndex(qrow+1,qcol));
				
			}
				
			if (inBounds (qrow-1, qcol) && isOpen(qrow-1,qcol) && ! isFull(qrow-1,qcol)) {
				myGrid[qrow-1][qcol] = FULL;
				qp.add(getIndex(qrow-1, qcol));
				
			}
			if (inBounds (qrow, qcol+1) && isOpen(qrow,qcol+1) && ! isFull(qrow,qcol+1)) {
				myGrid[qrow][qcol+1] = FULL;
				qp.add(getIndex(qrow, qcol+1));
				
			}
			
			if (inBounds (qrow, qcol-1) && isOpen(qrow,qcol-1) && ! isFull(qrow,qcol-1)) {
				myGrid[qrow][qcol-1] = FULL;
				qp.add(getIndex(qrow, qcol-1));
				
			}
		}
		
		
		
	}

}
