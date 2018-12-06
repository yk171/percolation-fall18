import java.util.*;

public class PercolationBFS extends PercolationDFSFast{
	public PercolationBFS(int size) {
		super(size);	
	}
	@Override
	protected void dfs(int row, int col) {
		int size = 0;
		int[] rowDelta = {-1,1,0,0};
	    int[] colDelta = {0,0,-1,1};
	    
	    Integer a = row*myGrid.length + col;	
	    
		if(! inBounds(row,col)) return;
		
	        
		Queue<Integer> qp = new LinkedList<>();
		myGrid[row][col] = FULL;
		size++;
		qp.add(myGrid[row][col]);
		while(qp.size() != 0) {
			Integer p = qp.remove();
			for(int i = 0; i < rowDelta.length; i++) {
				row = p/size + rowDelta[i];
				col = p%size + colDelta[i];
				if(inBounds(row, col) && myGrid[row][col] == FULL && myGrid[row][col] == OPEN) {
						qp.add(myGrid[row][col]);
						myGrid[row][col] = FULL;
						size++;
				}
			}
		}
	}
	
}
