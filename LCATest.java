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
	 * Contains - Done
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
	@Test
	public void testContains() {
		BinaryTree<Character, Character> BT = new BinaryTree<Character, Character>();
		//Test Empty tree 
		assertFalse("Test get on empty tree", BT.contains('a'));
		//Insert a bunch of values
		BT.insert('w', 'w');
		BT.insert('x', 'x');
		BT.insert('y', 'y');
		BT.insert('z', 'z');
		//Confirm null when get() value that isn't in tree
		assertFalse("Test contain on many node tree that doesn't contain key", BT.contains('a'));
		//Test get on valid value 
		//Cast to char because return type is value
		assertTrue("Test contains on many node tree that does contain key",  BT.contains('w')); 
	}
	@Test
	public void testInsert() {
		BinaryTree<Character, Character> BT = new BinaryTree<Character, Character>();
		
		//Test creating an node
		BT.insert('a', 'a');
		assertTrue("Testing insert on empty tree",  BT.contains('a'));
		
		//Test node sorting when inserted
		BT.insert('x', 'x');
		BT.insert('y', 'y');
		BT.insert('z', 'z');
		//Tests order with print function
		assertEquals("Testing insert of multiple nodes into tree", 
				"(()a(()x(()y(()z()))))", BT.printTree());
		
		//Test update of value in tree.
		BT.insert('q', 'f');
		assertEquals("Testing insert of multiple nodes into tree", 
				'f', (char)BT.get('q'));
		
		//Testing insert of null value. (Should delete node)
		BT.insert('y', null);
		assertEquals("Testing insert of null value into tree", 
				"(()a((()q())x(()z())))", BT.printTree());
		
		//Testing insert of null key. (Should have no effect)
		BT.insert(null, 'Q');
		assertEquals("Testing insert of null key into tree", 
				"(()a((()q())x(()z())))", BT.printTree());

	}
	@Test
	public void testLCA(){
		//Lowest Common Ancestor should require two keys and return key of LCA.	
		BinaryTree<Integer, Integer> BT = new BinaryTree<Integer, Integer>();
		
		//Testing empty tree.
		assertNull("Test LCA on empty tree", BT.LCA(1337, 212));
		
		//Testing one-node tree.
		BT.insert(1,1);
		
		//If parameters are not in tree then return null - should return null.	
		//One key present.
		assertNull("Test single node tree passed invalid keys", BT.LCA(2,1));
		
		//Both non-present keys.
		assertNull("Test single node tree passed invalid keys", BT.LCA(2,3));
		
		//Testing multi-node tree

	       	BT.insert(2, 2);   
	        BT.insert(3, 3);   
	        BT.insert(4, 4);   
	        BT.insert(5, 5);   
	        BT.insert(6, 6);   
	        BT.insert(7, 7);   
	        BT.insert(8, 8);   
	        BT.insert(9, 9);   
		
	    //If either given key is the root, should return the root
		assertEquals("Test single node tree passed root's key", 2, (int)BT.LCA(7,2));    
	        
	    assertEquals("Test many node tree", 4, (int)BT.LCA(6,4));
	    assertEquals("Test many node tree", 3, (int)BT.LCA(5,3));
	    assertEquals("Test many node tree", 1, (int)BT.LCA(1,7));
	    assertEquals("Test many node tree", 2, (int)BT.LCA(3,2));
	}

}
