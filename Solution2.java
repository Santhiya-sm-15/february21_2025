class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> l=new ArrayList<>();
            int level=q.size();
            for(int i=0;i<level;i++)
            {
                TreeNode x=q.poll();
                l.add(x.val);
                if(x.left!=null)
                    q.add(x.left);
                if(x.right!=null)
                    q.add(x.right);
            }
            res.add(0,l);
        }
        return res;
    }
}