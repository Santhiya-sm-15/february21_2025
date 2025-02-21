# february21_2025
The problems that I solved today

LEETCODE
1.Given a binary tree with the following rules: root.val == 0 For any treeNode: If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1 If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2 Now the binary tree is contaminated, which means all treeNode.val have been changed to -1. Implement the FindElements class: FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it. bool find(int target) Returns true if the target value exists in the recovered binary tree.

Code:
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

2.Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Code:
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

3.Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n]. You may return the answer in any order.

Code:
class Solution {
    public void f(int x,int n,int k,List<List<Integer>> res,List<Integer> l)
    {
        if(l.size()==k)
        {
            res.add(new ArrayList<>(l));
            return;
        }
        if(x>n)
            return;
        l.add(x);
        f(x+1,n,k,res,l);
        l.remove(l.size()-1);
        f(x+1,n,k,res,l);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        f(1,n,k,res,new ArrayList<>());
        return res;
    }
}

GEEKSFORGEEKS
1.Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:
         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

Code:
class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> st=new Stack<>();
        int i;
        for(i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='[' || c=='{' || c=='(')
                st.push(c);
            else if(c=='}' || c==']' || c==')')
            {
                if(!st.isEmpty() && ((st.peek()=='(' && c==')') || (st.peek()=='{' && c=='}') || (st.peek()=='[' && c=='')))
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
