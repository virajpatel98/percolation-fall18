
public class PercolationUF implements IPercolate{
	
	int[][] myGrid;
	int myOpenCount;
	IUnionFind myFinder;
	private final int VTOP; 
	private final int VBOTTOM;
	
	
	
	public PercolationUF(int size, IUnionFind finder) {
		myGrid = new int[size][size];
		myOpenCount = size;
		myFinder= finder;
		myFinder.initialize(size*size+2);
		VTOP = size*size;
		VBOTTOM = size*size+1;
		
	}
	
	public int getIndex(int row, int col) {

		return (row * myGrid.length + col);
		
	}
	
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}

	@Override
	public void open(int row, int col) {
		if(! inBounds(row,col)) throw new IndexOutOfBoundsException();
		
		if(isOpen(row,col)) return;
		
		
		myGrid[row][col] = OPEN;
		
		if(inBounds (row+1, col) && isOpen (row+1, col)) myFinder.union(getIndex(row, col), getIndex(row+1, col));
		
		if(inBounds (row, col+1) && isOpen (row, col+1)) myFinder.union(getIndex(row, col), getIndex(row, col+1));
		
		if(inBounds (row, col-1) && isOpen (row, col-1)) myFinder.union(getIndex(row, col), getIndex(row, col-1));
		
		if(inBounds (row-1, col) && isOpen (row-1, col)) myFinder.union(getIndex(row, col), getIndex(row-1, col));
		
		
		if(row ==0) myFinder.union(getIndex(row,col), VTOP);
		
		if (row == myOpenCount -1) myFinder.union(getIndex(row,col), VBOTTOM);
	
		
	}

	@Override
	public boolean isOpen(int row, int col) {
		if(! inBounds(row,col)) throw new IndexOutOfBoundsException();
		
		return myGrid[row][col] == OPEN;
	}

	@Override
	public boolean isFull(int row, int col) {
		if(! inBounds(row, col)) throw new IndexOutOfBoundsException();
		
		return myFinder.connected(getIndex(row,col), VTOP);
	}

	@Override
	public boolean percolates() {
		
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		
		return myOpenCount;
	}

}
