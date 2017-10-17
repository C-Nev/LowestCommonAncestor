import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	
	/*Will need to test all Binary Tree Functions
	 * Empty 
	 * Print -Done
	 * Insert
	 * Get
	 * Delete
	 *Then need to test LCA functions
	 *
	 */
	
	@Test
	public void testEmptyTree()
	{
		//Test isEmpty Function
	     	     
	}
	@Test
	public void testPrintTree()
	{
		//Test empty tree printing
	     BinaryTree<Character, Character> BT = new BinaryTree<Character, Character>();
	     assertEquals("Empty tree test print",
	             "()", BT.printTree());
	     
	     //Testing one node tree printing
	     BT.insert('a', 'a');
	     assertEquals("One node tree test print",
	             "(()a())", BT.printTree());
	     
	     
	     //Testing multiple node tree printing
	     BT.insert('w', 'w');
	     BT.insert('x', 'x');
	     BT.insert('y', 'y');
	     BT.insert('z', 'z');
	     
	     assertEquals("Many node test print",
	    		 "(()a(()w(()x(()y(()z())))))", BT.printTree());	     
	}
	
}
