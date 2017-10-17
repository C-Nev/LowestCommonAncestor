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
 
}