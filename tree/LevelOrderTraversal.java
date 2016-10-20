//This is a pusedo code
//For level order traversal, you need to know the height of the tree first

pubic static void PrintLevelOrder(TreeNode root)
  for d = 1 to height(tree)
    PrintGivenLevel(tree,d)
    
public static void PrintGivenLevel(TreeNode tree, int d)
  if(tree==null) return;
  if(d==1) print(tree.val);
  else if(d>1)
    PrintGivenLevel(tree.left,d-1);
    PrintGivenLevel(tree.right,d-1);
