import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void testInsert() {
		BinarySearchTree<Integer> tree = new BinarySearchTree();
		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(100);
		tree.insert(175);
		tree.insert(12);
		tree.insert(37);
		tree.insert(137);
		tree.insert(112);
		assertEquals( "12 25 37 50 75 100 112 125 137 150 175", tree.inOrder());
	
	}
	
	@Test
	void testPreOrder() {
		BinarySearchTree<Integer> tree = new BinarySearchTree();

		tree.insert(5);
		tree.insert(2);
		tree.insert(8);
		tree.insert(1);
		tree.insert(4);
		tree.insert(6);
		tree.insert(9);
		tree.insert(0);
		tree.insert(3);

		System.out.println(" :::" + tree.preOrderTraversal());
		assertEquals( "5 2 1 0 4 3 8 6 9", tree.preOrderTraversal());
	

	}
	
	
	@Test
	void testFind() {
		BinarySearchTree<Integer> tree = new BinarySearchTree();
		assertFalse( tree.find(80));

		tree.insert(100);
		assertTrue( tree.find(100));

		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(100);
		tree.insert(175);
		tree.insert(12);
		tree.insert(37);
		tree.insert(137);
		tree.insert(112);
assertTrue( tree.find(100));
assertTrue( tree.find(12));
assertTrue( tree.find(150));
assertTrue( tree.find(50));
assertFalse( tree.find(80));
	
	}
	
	@Test
	void testCount() {
		
		BinarySearchTree<Integer> tree = new BinarySearchTree();
		

		tree.insert(100);

		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(100);
		tree.insert(175);
		tree.insert(12);
		tree.insert(37);
		tree.insert(137);
		tree.insert(112);
assertEquals( 11, tree.nodeCount());
}

	@Test
	void testHeight() {
BinarySearchTree<Integer> tree = new BinarySearchTree();
		

		tree.insert(100);

		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(100);
		tree.insert(175);
		tree.insert(12);
		tree.insert(37);
		tree.insert(137);
		tree.insert(112);
assertEquals( 3, tree.getHeight());
		
	}
	
	@Test
	void testLeaf() {
BinarySearchTree<Integer> tree = new BinarySearchTree();
		

		tree.insert(100);

		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(100);
		tree.insert(175);
		tree.insert(12);
		tree.insert(37);
		tree.insert(137);
		tree.insert(112);
//System.out.print(tree.numberOfLeaves());		
	}
	
	@Test
	void testPostOrder() {
		BinarySearchTree<Integer> tree = new BinarySearchTree();

		tree.insert(100);
		tree.insert(50);
		tree.insert(150);
		tree.insert(25);
		tree.insert(75);
		tree.insert(125);
		tree.insert(100);
		tree.insert(175);
		tree.insert(12);
		tree.insert(37);
		tree.insert(137);
		tree.insert(112);
	//	assertEquals( "100 50 25 12 37 75 150 125 112 137 175", tree.postOrderTraversal());
		System.out.println(tree.inOrder());

		System.out.println(tree.preOrderTraversal());
		System.out.println(tree.postOrderTraversal());
	}


}
