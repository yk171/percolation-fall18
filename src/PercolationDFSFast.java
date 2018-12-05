
public class PercolationDFSFast extends PercolationDFS {
		
		public PercolationDFSFast(int size) {
			super(size);
		}
		@Override
		protected void updateOnOpen(int row, int col) {
			if(row == 0) dfs(row,col);
			else {
			if((row < myGrid[0].length) && isFull(row+1, col)) dfs(row,col);
			if(isFull(row-1, col)) dfs(row,col);
			if((col < myGrid.length) && isFull(row, col+1)) dfs(row,col);
			if(isFull(row, col-1) && col != 0) dfs(row,col);
			}
				
		}
	}