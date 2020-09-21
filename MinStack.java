class MinStack {

    /** initialize your data structure here. */
    class Node {
        int value;
        int minValue;
        Node next;
        public Node (int value, int minValue) {
            this.value=value;
            this.minValue=minValue;
        }
    }
    Node top;
    
    public MinStack() {
        top=null;
    }
    
    public void push(int x) {
      
      if (top==null) {
         top=new Node(x, x);
         top.next=null;
          
      } else {
         Node preTop=top;
         int min1=x;
         if (top.minValue<x) {
             min1=top.minValue;
         }
         top=new Node(x, min1);
         top.next=preTop;
      }
    }
    
    public void pop() {
        if (top==null) {
            return;
        }
        Node pre=top.next;
        top=pre;
    }
    
    public int top() {
       return top.value;
    }
    
    public int getMin() {
        return top.minValue;
    }
        
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */