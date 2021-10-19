class MyStack {

    Deque<Integer> list = new LinkedList<>();
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        list.add(x);
    }
    
    public int pop() {
        return list.removeLast();      
    }
    
    public int top() {
        return list.peekLast();
    }
    
    public boolean empty() {
        return list.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
