public class XStack {
    MysteryX stack = new MysteryX();
    public void push(int value)
    {
        stack.insertFront(value);
    }
    public int pop()
    {
        return stack.deleteFront();
    }
    public int peek()
    {
        return stack.getFront();
    }
}
