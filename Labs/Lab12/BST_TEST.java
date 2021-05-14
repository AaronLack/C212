import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/29/20
 * Class BST_TESTS, for JUNIT tests for all of my methods
 * Make a bst tree from main in BST.java and do assert equals for the testing.
 */


public class BST_TEST {

	@Test
	public void test() {
		BST<Integer, Character> bstTree = new BST<>();
		bstTree.put((int) 'p','p');
		bstTree.put((int) 'g','g');
		bstTree.put((int) 'w','w');
		bstTree.put((int) 'c','c');
		bstTree.put((int) 'k','k');
		bstTree.put((int) 's','s');
		bstTree.put((int) 'c','c');
		bstTree.put((int) 'y','y');
		bstTree.put((int) 'a','a');
		bstTree.put((int) 'a','a');
		bstTree.put((int) 'e','e');
		bstTree.put((int) 'i','i');
		bstTree.put((int) 'q','q');
		bstTree.put((int) 'u','u');
		bstTree.put((int) 'q','q');
		bstTree.put((int) 'x','x');
		
		BST<Integer, Character> testTree = bstTree;
		
		//equals
		boolean output = bstTree.equals(testTree);
		assertEquals(output, true);
		
		//isBalanced
		boolean output2 = bstTree.isBalanced();
		assertEquals(output2, true);
		
		//toString
		String output3 = bstTree.toString();
		assertEquals(output3, "Pre-Order: 112 103 99 97 97 99 101 107 105 119 115 113 113 117 121 120 " + "\n" + "Post-Order: 97 97 101 99 99 105 107 103 113 113 117 115 120 121 119 112 " + "\n" + "In-Order: 97 97 99 99 101 103 105 107 112 113 113 115 117 119 120 121 ");
		
		//countLeafNode
		int output4 = bstTree.countLeafNodes();
		assertEquals(output4, 6);
		
		//getOneChildNodes
		int output5 = bstTree.getOneChildNodes();
		assertEquals(output5, 5);
		
		//getTwoChildrenNodes
		int output6 = bstTree.getTwoChildrenNodes();
		assertEquals(output6, 5);
		
		//removeDuplicates
		BST<Integer, Character> removeTree = bstTree.removeDuplicates();
		String output7 = removeTree.toString();
		assertEquals(output7, "Pre-Order: 97 99 101 103 105 107 112 113 115 117 119 120 121 " + "\n" + "Post-Order: 121 120 119 117 115 113 112 107 105 103 101 99 97 " + "\n" + "In-Order: 97 99 101 103 105 107 112 113 115 117 119 120 121 ");
		
		//sumLeft
		int output8 = bstTree.sumLeft((int) 'p');
		assertEquals(output8, 808);
		
		//sumRight
		int output9 = bstTree.sumRight((int) 'p');
		assertEquals(output9, 818);
		
		//getUpperHalf
		BST<Integer, Character> upperTree = bstTree.getUpperHalf();
		String output10 = upperTree.toString();
		assertEquals(output10, "Pre-Order: 112 103 119 " + "\n" + "Post-Order: 103 119 112 " + "\n" + "In-Order: 103 112 119 ");
		
	}

}
