import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * Header
 * @Author: Aaron Lack, alack
 * Last edited: 4/29/20
 * Class BST, Making new global variables output for displaying data,
 * A counter for updating things,
 * A hashset to help remove duplicates, and an ArrayList for the upper tree.
 * Then, I had a inner class node with the node to help construct the trees. 
 * A lot of the functions need helper functions so I can implement them correctly using recursion
 * In the main method, I created a bst tree and a random tree to test all my methods
 * And finally, I will do JUNIT Tests.
 */

public class BST<Key extends Comparable<Key>, Value> {

	 private Node root;
	 private String output = "";
	 private int counter = 0;
	 private Set<Key> keys = new HashSet<Key>();
	 private ArrayList<Key> upper = new ArrayList<>();
	
	  // note: the outer class has direct access to values in this inner class
	  private class Node {
		  private Key key;
		  private Value value;
		  private Node lChild;
		  private Node rChild;
		
		  // number of nodes at this subtree
		  // N for the root == # of nodes in entire tree
		  // N for leaf node == 1
		  // N needs to be updated everytime a new node is inserted into the tree
		  private int N;
		
		  public Node(Key key, Value value, int N) {
			  this.key = (Key) key;
			  this.value = value;
			  this.N = N;
		  }
 }

 //TODO: return # of nodes in the tree
 public int size() {
	 return root.N; 
 }

//TODO: return value associated with key, or null if key doesn't exist
 public Value get(Key key) {
	  Key num = key;
	  boolean bool = true;
	  Node currentNode = this.root;
	  while(bool) {
		  if(num.compareTo(currentNode.key) < 0) {
			  if(currentNode.lChild != null) {
				  currentNode = currentNode.lChild;
			  }
			  else {
				  bool = false;
			  }
		  }
		  else {
			  if(currentNode.rChild != null) {
				  currentNode = currentNode.rChild;
			  }
			  else {
				  bool = false;
			  }
		  }
	  }
	  return null;
 }
 
//TODO: insert key/value pair into tree and update the value of N 
 public void put(Key key, Value val) {
     Key num = key;
     Value value = val;
     boolean bool = true;
     Node currentNode = this.root;
     if(currentNode == null) {
         this.root = new Node(num, value, 1);
     }
     else {
         while(bool) {
             if(num.compareTo(currentNode.key) < 0) {
                 if(currentNode.lChild != null) {
                     currentNode.N++;
                     currentNode = currentNode.lChild;
                 }
                 else {
                     currentNode.lChild = new Node(num, value, 1);
                     bool = false;
                 }
             }
             else {
                 if(currentNode.rChild != null) {
                     currentNode.N++;
                     currentNode = currentNode.rChild;
                 }
                 else {    
                     currentNode.rChild = new Node(num, value, 1);             
                     bool = false;
                 }
             }
         }     
     }
 }
 
 
//preOrder method for walk method
public void preOrder(Node node) { 
	 if (node == null) {
		 return; 
	 }
	 //Print data of node
	 output += node.key + " ";  

	 //Recur on left subtree
	 preOrder(node.lChild); 

	 //Recur on right subtree
	 preOrder(node.rChild); 
}
 
//postOrder method for walk method
public void postOrder(Node node) { 
	 if (node == null) {
		 return; 
	 }
	 //Recur on left subtree
	 postOrder(node.lChild); 

	 //Recur on right subtree
	 postOrder(node.rChild); 

	 //Print data of node
	 output += node.key + " "; 
} 

//inOrder method for walk method
public void inOrder(Node node) { 
	 if (node == null) {
		 return; 
	 }
	 //Recur on left subtree
	 inOrder(node.lChild); 

	 //Print data of node 
	 output += node.key + " "; 

	 //Recur on right subtree
	 inOrder(node.rChild);   
}  
 
//TODO: walk the tree in order & print the values
// if choice is “in” then perform in-order walk (default)
// if choice is “pre” then perform pre-order walk
// if choice is “post” then perform post-order walk
// any other choice or wrong choice will use default option 
 public String walk(String choice) {
	 String option = "in";
	 output = "";
	 if(choice.equals("pre") || choice.equals("post")) {
		 option = choice;
	 }
	 if(option.equals("pre")) {
		 preOrder(root);
	 }
	 if(option.equals("post")) {
		 postOrder(root);
	 }
	 if(option.equals("in")) {
		 inOrder(root);
	 }
	 return output;
 }
 
 //TODO: "Returns a pre-order, post-order, and in-order walk of the tree printing the values"
 @Override
 public String toString() {
	 return "Pre-Order: " + walk("pre") + "\nPost-Order: " + walk("post") + "\nIn-Order: " + walk("in");
 }
 
 //TODO: Returns whether this tree (using root node) is exactly same as another BST
 @Override
 public boolean equals(Object obj) {
	 if(this.toString().equals(obj.toString())) {
		 return true;
	 }
	 else {
		 return false;
	 }
 }

 //Returns true if this tree (using root node) is perfectly balanced, return false otherwise.   
 public boolean isBalanced() { 
     if(treeHeight(root.lChild) == treeHeight(root.rChild)) {
         return true;
     }
     return false;
 } 
 
 public int treeHeight(Node node) { 
	 if (node == null) {
		 return 0; 
	 } 
     else { 
         int leftHeight = treeHeight(node.lChild); 
         int rightHeight = treeHeight(node.rChild); 

         if (leftHeight > rightHeight) {
        	 return (leftHeight + 1); 
         }
         else {
        	 return (rightHeight + 1);  
         }
     } 
 }

 //A helper function for the countLeafNodes method.
 public void leafHelper(Node node) { 
	  if (node == null) {
			 return; 
	  } 
	  //Recur on left subtree 
	  leafHelper(node.lChild); 

	  //Recur on right subtree 
	  leafHelper(node.rChild); 

	  //Dealing with the node 
	  if(node.lChild == null && node.rChild == null) {
		  counter++;
	  }
 }
 
  //Returns the number of leaf nodes in the BST
  public int countLeafNodes() {
	  counter = 0;
	  leafHelper(root);
	  return counter;
  }

  //A helper function for the getOneChildNodes method.
  public void oneHelper(Node node) { 
	  if (node == null) {
		  return;
	  }
	  //Recur on left subtree 
	  oneHelper(node.lChild); 

	  //Recur on right subtree 
	  oneHelper(node.rChild); 

	  //Dealing with the node 
	  //Only one has to be true, so I am using an xor boolean operation ^
	  if(node.lChild == null ^ node.rChild == null)  {
		  counter++;
	  }
  }

  //returns the number of nodes in BST with only one child
  public int getOneChildNodes(){
	  counter = 0;
	  oneHelper(root);
	  return counter;
  }
 
  //A helper function for the getTwoChildrenNodes method.
  public void twoHelper(Node node) {
	  if (node == null) {
		  return;
	  }
	  //Recur on left subtree 
	  twoHelper(node.lChild); 

	  //Recur on right subtree 
	  twoHelper(node.rChild); 

	  //Dealing with the node 
	  if(node.lChild != null && node.rChild != null) {
		  counter++;
	  }
  }
  
  
  //returns the number of nodes in BST with two children.
  public int getTwoChildrenNodes() {
	  counter = 0;
	  twoHelper(root);
	  return counter;
  } 
  
  //A helper method for removeDuplicates()
  public void removeHelper(Node n) {
	  if(n == null) {
		  return;
	  }
	  keys.add(n.key);
	  removeHelper(n.lChild);
	  removeHelper(n.rChild);
  }
  
  //Returns a new BST with the duplicates removed from the original tree.
  public BST removeDuplicates() {
	  keys.clear();
      removeHelper(root);
      BST<Integer,Character> newBST = new BST<>();
      for(Key i: keys) {
    	  int key = (int) i;
          char val = (char) key;
          newBST.put(key, val);
      }
      return newBST;
  }
  
  //Returns the sum of keys of nodes in the left branch of the passed key value
  public int sumLeft(Key key){
      Node top;
      counter = 0;
      Node currentNode = root;
      while(key.compareTo(currentNode.key)!=0) {
          if(key.compareTo(currentNode.key)>0) {
              if(currentNode.rChild!=null) {
                  currentNode = currentNode.rChild;
              }
          }
          if(key.compareTo(currentNode.key)<0) {
              if(currentNode.lChild!=null) {
                  currentNode = currentNode.lChild;
              }
          }
          
      }
      top = currentNode;
      sumTree(top.lChild);
      return counter;
  }
  
  public void sumTree(Node node) { 
      if (node == null) {
    	  return;
      }

      //Recur on left child
      sumTree(node.lChild); 

      //Print the data of node
      counter += (int)node.key; 

      //Recur on right child
      sumTree(node.rChild); 
  }

  //Returns the sum of keys of nodes in the right branch of the passed key value
  public int sumRight(Key key){
      Node top;
      counter = 0;
      Node currentNode = root;
      while(key.compareTo(currentNode.key)!=0) {
          if(key.compareTo(currentNode.key)>0) {
              if(currentNode.rChild!=null) {
                  currentNode = currentNode.rChild;
              }
          }
          if(key.compareTo(currentNode.key)<0) {
              if(currentNode.lChild!=null) {
                  currentNode = currentNode.lChild;
              }
          }
      }
      top = currentNode;
      sumTree(top.rChild);
      return counter;
  }

  //returns a new BST with the height that is half of the original tree 
  //(including all the top nodes starting with root node and the ones connected to root node if needed).
  public BST getUpperHalf () {
      counter = (int) Math.ceil(treeHeight(root)/2);
      upper.clear();
      addUpper(root);
      BST<Integer,Character>  upperBST = new BST<>();
      for(int k=upper.size()-1; k>=0; k--) {
          int key = (int) upper.get(k);
          char val = (char) key;
          upperBST.put(key, val);
      }
      return upperBST;
  }
  
  public int addUpper(Node node) {
      if (node == null) {
    	  return 0;
      }
      else { 
          int lHeight = addUpper(node.lChild); 
          int rHeight = addUpper(node.rChild); 
          
          if(lHeight>=counter+1||rHeight>=counter+1) {
              upper.add(node.key);
          }
          System.out.println(upper);
          
          if (lHeight > rHeight) {
        	  return (lHeight + 1);
          }
               
           else {
        	   return (rHeight + 1); 
           }  
      } 
  }

 public static void main(String[] args) {

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
	  
	  bstTree.walk("in");
	  
	  //Testing all implemented functions for bstTree
	  BST<Integer, Character> testTree = bstTree;
	  System.out.println("BST Tree");
	  System.out.println("Get: " + bstTree.get((int) 'b'));
	  System.out.println("Get: " + bstTree.get((int) 'c'));
	  System.out.println("toString");
	  System.out.println(bstTree.toString());
	  System.out.println("Balanced: " + bstTree.isBalanced());
	  System.out.println("Equals: " + bstTree.equals(testTree));
	  System.out.println("countLeafNodes: " + bstTree.countLeafNodes());
	  System.out.println("getOneChildNodes: " + bstTree.getOneChildNodes());
	  System.out.println("getTwoChildrenNodes: " + bstTree.getTwoChildrenNodes());
	  System.out.println("Sum Left: " + bstTree.sumLeft((int) 'p'));
	  System.out.println("Sum Right: " + bstTree.sumRight((int) 'p'));
	  
	  BST<Integer, Character> upperTree = bstTree.getUpperHalf();
	  System.out.println("Upper Tree");
	  System.out.println(upperTree.toString());
	  BST<Integer, Character> removeTree = bstTree.removeDuplicates();
	  System.out.println("Remove Duplicates");
	  System.out.println(removeTree.toString());
	  System.out.println("Walk: " + bstTree.walk("pre"));
	  
	  System.out.println();

	  //note: not all of these chars will end up being generated from the for loop
	  //some of these return values will be null
	  Random rand = new Random();
	  BST<Integer, Character> randomTree = new BST<>();
	
	  for (int i = 0; i < 13; i++) {
		  int key = rand.nextInt(26) + 'a';
		  char val = (char) key;
		  randomTree.put(key, val);
	  }                                                               

	  //Testing all implemented functions for randomTree
	  System.out.println("Random Tree");
	  System.out.println("Get: " + randomTree.get((int) 'a'));
	  System.out.println("Get: " + randomTree.get((int) 'b'));
	  System.out.println("Get: " + randomTree.get((int) 'c'));
	  System.out.println("Get: " + randomTree.get((int) 'f'));
	  System.out.println("Get: " + randomTree.get((int) 'k'));
	  System.out.println("Get: " + randomTree.get((int) 'x'));
	  System.out.println("toString");
	  System.out.println(randomTree.toString());
	  System.out.println("Balanced: " + randomTree.isBalanced());
	  System.out.println("Equals: " + randomTree.equals(testTree));
	  System.out.println("countLeafNodes: " + randomTree.countLeafNodes());
	  System.out.println("getOneChildNodes: " + randomTree.getOneChildNodes());
	  System.out.println("getTwoChildrenNodes: " + randomTree.getTwoChildrenNodes());
	  System.out.println("Sum Left: " + randomTree.sumLeft((int) randomTree.root.key));
	  System.out.println("Sum Right: " + randomTree.sumRight((int) randomTree.root.key));
	  
	  BST<Integer, Character> upperTreeTwo = randomTree.getUpperHalf();
	  System.out.println("Upper Tree");
	  System.out.println(upperTreeTwo.toString());
	  BST<Integer, Character> removeTreeToo = randomTree.removeDuplicates();
	  System.out.println("Remove Duplicates");
	  System.out.println(removeTreeToo.toString());
	  System.out.println(randomTree.walk("post"));
	  randomTree.walk("in");
	 }
}