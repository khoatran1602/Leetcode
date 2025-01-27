class MyQueue {

    private final Stack<Integer> top;
    private final Stack<Integer> bottom;
    
    public MyQueue() {
        top = new Stack<>();
        bottom = new Stack<>();
    }

    public void push(int x) {
        top.push(x);
    }

    public int pop() {
        revereStack(top, bottom);
        int res = bottom.pop();
        revereStack(bottom, top);
        return res;
    }

    public int peek() {
        revereStack(top, bottom);
        int res = bottom.peek();
        revereStack(bottom, top);
        return res;
    }

    public boolean empty() {
        return top.isEmpty();
    }

    private void revereStack(Stack<Integer> top, Stack<Integer> bottom) {
        while (!top.isEmpty()) {
            bottom.push(top.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
