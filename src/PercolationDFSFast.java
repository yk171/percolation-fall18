
public class PercolationDFSFast extends PercolationDFS {
		
		public PercolationDFSFast(int size) {
			super(size);
		}
		@Override
		protected void updateOnOpen(int row, int col) {
			
			for (int k = 0; k < myGrid[0].length; k++) {
				if(isFull(0,k)) dfs(0, k);
			}
			
				if(isFull(row+1, col)) dfs(row,col);
				if(isFull(row-1, col)) dfs(row,col);
				if(isFull(row, col+1)) dfs(row,col);
				if(isFull(row, col-1)) dfs(row,col);
		}
	}