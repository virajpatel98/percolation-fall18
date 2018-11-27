
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);
	}
	
	protected void updateOnOpen(int row, int col) {
		if (row ==0) dfs(row,col);
		
		if (inBounds(row+1, col) && isFull(row+1,col)) dfs(row,col);
		
		if (inBounds(row-1, col) && isFull(row-1,col)) dfs(row,col);
		
		if (inBounds(row, col+1) && isFull(row,col+1)) dfs(row,col);
		
		if (inBounds(row, col-1) && isFull(row,col-1)) dfs(row,col);
	}

}
