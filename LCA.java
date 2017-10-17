class Entity{
    public int count;
    public TreeNode node;
 
    public Entity(int count, TreeNode node){
        this.count = count;
        this.node = node;
    }
}
 
public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaHelper(root, p, q).node;
    }
 
    public Entity lcaHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return new Entity(0, null);
 
        Entity left = lcaHelper(root.left, p, q);
        if(left.count==2) 
            return left;
 
        Entity right = lcaHelper(root.right,p,q);
        if(right.count==2) 
            return right;
 
        int numTotal = left.count + right.count;
        if(root== p || root == q){
            numTotal++;
        }
 
        return new Entity(numTotal, root);      
    }
}