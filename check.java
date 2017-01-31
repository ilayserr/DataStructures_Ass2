
/*
Assignment number : 2
File Name : check.java
Name : Ilay Serr
Email : ilay92@gmail.com
*/

public class check {
	 
	 public static void main (String[] args) {
		 Tree check = new Tree();
		 TreeNode a = new TreeNode(10);
		 check.insert(a);
		 TreeNode b = new TreeNode(8);
		 check.insert(b);
		 TreeNode c = new TreeNode(4);
		 check.insert(c);
		 TreeNode d = new TreeNode(9);
		 check.insert(d);
		 TreeNode e = new TreeNode(15);
		 check.insert(e);
		 TreeNode f = new TreeNode(11);
		 check.insert(f);
		 TreeNode g = new TreeNode(8.5);
		 check.insert(g);
		 TreeNode h = new TreeNode(18);
		 check.insert(h);
		 TreeNode j = new TreeNode(7);
		 check.insert(j);
		 for (int i = 1; i <= check.root.size; i++) {
			double num = check.OSSelect(i).getKey();
			System.out.print(num + "\t");
		 }
		 System.out.println();
		 System.out.println("\t" + check.OSRank(a)+ " " + a);
		 System.out.println("\t" + check.OSRank(b) + " " + b);
		 System.out.println("\t" + check.OSRank(c) + " " + c);
		 System.out.println("\t" + check.OSRank(d) + " " + d);
		 System.out.println("\t" + check.OSRank(e) + " " + e);
		 System.out.println("\t" + check.OSRank(f) + " " + f);
		 System.out.println("\t" + check.OSRank(g) + " " + g);
		 System.out.println("\t" + check.OSRank(h) + " " + h);
		 System.out.println("\t" + check.OSRank(j) + " " + j);
		 
		 /*
		 System.out.println();
		 System.out.println("deleted 15");
		 check.delete(e);
		 for (int i = 1; i <= check.root.size; i++) {
			double num = check.OSSelect(i).getKey();
			System.out.print(num + "\t");
		 }
		 */
		 check.delete(a); 
		 System.out.println();
		 System.out.println("deleted 10 - root");
		 for (int i = 1; i <= check.root.size; i++) {
			double num = check.OSSelect(i).getKey();
			System.out.print(num + "\t");
		 }
		
		 check.delete(g);
		 System.out.println();
		 System.out.println("deleted 8.5");
		 for (int i = 1; i <= check.root.size; i++) {
			double num = check.OSSelect(i).getKey();
			System.out.print(num + "\t");
		 }
	 }
}
