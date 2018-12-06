
public class PercolationUF implements IPercolate{
	private boolean myGrid[][];
	private int myOpenCount;
	private IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	public PercolationUF(int size, IUnionFind finder) {
		boolean g = myGrid[size][size];
		VTOP = size*size;
		VBOTTOM = size*size + 1;
		int myOpenCount;
		myFinder = finder;
		finder.initialize(size*size+2);
	}
	@Override
	public void open(int row, int col) {
		if(! inBounds(row, col)) {
			throw new IndexOutOfBoundsException("Out of Bounds");	
		}
		if(!isOpen(row,col)) {
			myGrid[row][col] = true;
			if(inBounds(row+1,col) && isOpen(row+1,col)) {
				int a = row*myGrid.length + col;
				myFinder.connected(a,(row+1)*myGrid.length + col);
			}
			if(inBounds(row-1,col) && isOpen(row-1,col)) {
				int a = row*myGrid.length + col;
				myFinder.connected(a,(row-1)*myGrid.length + col);
			}
			if(inBounds(row,col+1) && isOpen(row,col+1)) {
				int a = row*myGrid.length + col;
				myFinder.connected(a,(row)*myGrid.length + col+1);
			}
			if(inBounds(row,col-1) && isOpen(row+1,col-1)) {
				int a = row*myGrid.length + col;
				myFinder.connected(a,(row)*myGrid.length + col-1);
			}
		}
	}

	@Override
	public boolean isOpen(int row, int col) {
		if(! inBounds(row, col)) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		return myGrid[row][col];
	}

	@Override
	public boolean isFull(int row, int col) {
		if(! inBounds(row, col)) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		int size = myGrid.length;
		int num = row*size + col;
		return myFinder.connected(num,VTOP);
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
}
