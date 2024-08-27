class Tree {
    ArrayList<Integer> post(Node node)
    {
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Node> st=new Stack<>();
        if(node==null) return list;
        st.push(node);
        while(!st.isEmpty())
        {
            Node curr=st.pop();
            list.add(0,curr.data);
            if(curr.left!=null)
            {
                st.push(curr.left);
            }
            if(curr.right!=null)
            {
                st.push(curr.right);
            }
        }
        return list;
    }
    ArrayList<Integer> postOrder(Node node) {
        // code here
        return post(node);
    }
}
