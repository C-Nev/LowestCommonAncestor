import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	/*
	 * Will need to test all Binary Tree Functions 
	 * Empty -Done 
	 * Print -Done
	 * Size - Done
	 * Insert 
	 * Get 
	 * Delete 
	 * Then need to test LCA functions
	 *
	 */

	@Test
	public void testEmptyTree() {
		// Test isEmpty Function
		BinaryTree<Character, Character> BT = new BinaryTree<Character, Character>();
		assertTrue(BT.isEmpty());
		BT.insert('a', 'a');
		assertFalse(BT.isEmpty());
	}

	@Test
	public void testSize() {
		// Test Size of Tree Function
		BinaryTree<Character, Character> BT = new BinaryTree<Character, Character>();
		assertEquals(0, BT.size());
		BT.insert('a', 'a');
		assertEquals(1, BT.size());
		BT.insert('w', 'w');
		BT.insert('x', 'x');
		BT.insert('y', 'y');
		BT.insert('z', 'z');
		assertEquals(5, BT.size());
	}

	@Test
	public void testPrintTree() {
		// Test empty tree printing
		BinaryTree<Character, Character> BT = new BinaryTree<Character, Character>();
		assertEquals("Empty tree test print", "()", BT.printTree());

		// Testing one node tree printing
		BT.insert('a', 'a');
		assertEquals("One node tree test print", "(()a())", BT.printTree());

		// Testing multiple node tree printing
		BT.insert('w', 'w');
		BT.insert('x', 'x');
		BT.insert('y', 'y');
		BT.insert('z', 'z');

		assertEquals("Many node test print", "(()a(()w(()x(()y(()z())))))", BT.printTree());
	}
	
	@Test
	public void testGet() {
		BinaryTree<Character, Character> BT = new BinaryTree<Character, Character>();
		//Test Empty tree 
		assertNull("Test get on empty tree", BT.get('a'));
		//Insert a bunch of values
		BT.insert('w', 'w');
		BT.insert('x', 'x');
		BT.insert('y', 'y');
		BT.insert('z', 'z');
		//Confirm null when get() value that isn't in tree
		assertNull("Testing get on multiple node tree that doesn't contain key", BT.get('a'));
		//Test get on valid value 
		//Cast to char because return type is value
		assertEquals("Testing get on multiple node tree that does contain key", 'c', (char) BT.get('c')); 
	}

}
