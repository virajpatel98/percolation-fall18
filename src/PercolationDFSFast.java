
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);
	}
	
	protected void updateOnOpen(int row, int col) {
		
		int check = 0;
		
		
		if (row ==0) check = 1;
		
		if (inBounds(row+1, col) && isFull(row+1,col)) check = 1;
		
		if (inBounds(row-1, col) && isFull(row-1,col)) check =1;
		
		if (inBounds(row, col+1) && isFull(row,col+1)) check =1;
		
		if (inBounds(row, col-1) && isFull(row,col-1)) check =1;
		
		if (check ==1) dfs(row,col);
	}

}
