import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	/*
	 * Will need to test all Binary Tree Functions 
	 * Empty -Done 
	 * Print -Done
	 * Size - Done
	 * Insert 
	 * Get - Done
	 * Delete - Done
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
		assertEquals("Testing get on multiple node tree that does contain key", 'w', (char) BT.get('w')); 
	}
	@Test
	public void testDelete(){
		/*
		 * Unlike other functions this is also ripped from second year Data Structures module
		 */
		BinaryTree<Integer, Integer> BT = new BinaryTree<Integer, Integer>();
		
		//Test empty tree deletion
		BT.delete(1);
        assertEquals("Deleting from empty tree", "()", BT.printTree());
        
        
        BT.insert(7, 7);   //        _7_
        BT.insert(8, 8);   //      /     \
        BT.insert(3, 3);   //    _3_      8
        BT.insert(1, 1);   //  /     \
        BT.insert(2, 2);   // 1       6
        BT.insert(6, 6);   //  \     /
        BT.insert(4, 4);   //   2   4
        BT.insert(5, 5);   //        \
                         //         5
        
        assertEquals("Testing constructed tree is as expected.",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", BT.printTree());
        
        //Test deleting key not present in tree. Should have no effect.
        BT.delete(9);
        assertEquals("Deleting non-existent key",
                "(((()1(()2()))3((()4(()5()))6()))7(()8()))", BT.printTree());

        
        //Test deleting leaf.
        BT.delete(8);
        assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", BT.printTree());

        //Test deleting node with single child.
        BT.delete(6);
        assertEquals("Deleting node with single child",
                "(((()1(()2()))3(()4(()5())))7())", BT.printTree());

        //Test deleting node with two children
        BT.delete(3);
        assertEquals("Deleting node with two children",
                "(((()1())2(()4(()5())))7())", BT.printTree());
	}

}
