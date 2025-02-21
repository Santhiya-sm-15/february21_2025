class FindElements {
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root=root;
        Queue<TreeNode> q=new LinkedList<>();
        root.val=0;
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode x=q.poll();
            if(x.left!=null)
            {
                if(x.left.val==-1)
                    x.left.val=2*x.val+1;
                q.add(x.left);
            }
            if(x.right!=null)
            {
                if(x.right.val==-1)
                    x.right.val=2*x.val+2;
                q.add(x.right);
            }
        }
    }
    public boolean find(int target) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode x=q.poll();
            if(x.val==target)
                return true;
            if(x.left!=null)
                q.add(x.left);
            if(x.right!=null)
                q.add(x.right);
        }
        return false;
    }
}