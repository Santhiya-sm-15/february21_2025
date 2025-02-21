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