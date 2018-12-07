import static org.junit.Assert.*;
import org.junit.Test;

public class TestUFPercolation {
	
	public IPercolate getPercolator(int size) {
		IUnionFind finder = new QuickUWPC();
		IPercolate perc = new PercolationUF(finder,size);
		return perc;
		//return null;
	}
		
	/**
	 * This test checks if PercolationUF's isOpen method works correctly
	 */
	@Test(timeout = 20000)
	public void testUFIsOpen() {
		IPercolate uf = getPercolator(10);
		for (int i = 1; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				uf.open(i, j);
				assertTrue("This test checks if PercolationUF's isOpen method " + "works correctly", uf.isOpen(i, j));
			}
	}

	/**
	 * This test checks if PercolationUF's isFull method works correctly
	 */
	@Test(timeout = 20000)
	public void testUFIsFull() {
		IPercolate uf = getPercolator(10);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++) {
				System.out.println("Testprint " + i +" " + j);
				System.out.println(uf == null);
				uf.open(i, j);
				System.out.println("Testprint " + i +" " + j);
				assertTrue("This test checks if PercolationUF's isFull method " + "works correctly", uf.isFull(i, j));
			}
	}
	
	/**
	 * This test checks if PercolationUF' percolates method works correctly
	 */
	@Test(timeout = 20000)
	public void testUFPercolates() {
		IPercolate uf = getPercolator(10);
		testPercolates(uf);
	}
	

	private void testPercolates(IPercolate perc) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 10; j++) {
				perc.open(i, j);
				assertFalse("This test checks if " + perc.getClass().getName() + " percolates method works correctly",
						perc.percolates());
			}
		perc.open(9, 0);
		assertTrue("This test checks if " + perc.getClass().getName() + "percolates method works correctly",
				perc.percolates());
	}
	

	/**
	 * Check if Exception is thrown unless (0 <= i < N) and (0 <= j < N)
	 */
	private static void bounds(IPercolate perc, int N, int i, int j) {
		boolean passed1 = false;
		boolean passed2 = false;
		boolean passed3 = false;
		System.out.println("  *  N = " + N + ", (i, j) = (" + i + ", " + j + ")");
		try {
			perc.open(i, j);
		} catch (Exception e) {
			passed1 = true;
		}
		assertTrue("This test checks if Exception thrown for open() for " + perc.getClass().getName(), passed1);

		try {
			boolean b = perc.isOpen(i, j);
		} catch (Exception e) {
			passed2 = true;
		}
		assertTrue("This test checks if Exception thrown for isOpen() for " + perc.getClass().getName(), passed2);

		try {
			boolean b = perc.isFull(i, j);
		} catch (Exception e) {
			passed3 = true;
		}
		assertTrue("This test checks if Exception thrown for isFull() for " + perc.getClass().getName(), passed3);
	}

	private void testBounds(IPercolate perc) {
        bounds(perc, 10, -1,  5);
        bounds(perc, 10, 11,  5);
        bounds(perc, 10, 10,  5);
        bounds(perc, 10,  5, -1);
        bounds(perc, 10,  5, 11);
        bounds(perc, 10,  5, 10);
	}
	/**
	 * Check if Exception is thrown when (i, j) are out of bounds
	 */
	@Test(timeout = 2000)
	public void testBounds() {
		IPercolate uf = getPercolator(10);
		testBounds(uf);
	}

}
