
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
		IUnionFind a = finder;
		finder.initialize(size*size+2);
	}
	@Override
	public void open(int row, int col) {
		if(! inBounds(row, col)) {
			throw new IndexOutOfBoundsException("Out of Bounds");	
		}
	}

	@Override
	public boolean isOpen(int row, int col) {
		if(! inBounds(row, col)) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
			else return true;
	}

	@Override
	public boolean isFull(int row, int col) {
		if(! inBounds(row, col)) {
			throw new IndexOutOfBoundsException("Out of Bounds");
		}
		int size = myGrid.length;
		int num = row*size + col;
		if(myFinder.connected(num,VTOP)) return true; 
		else return false;
	}

	@Override
	public boolean percolates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
}
