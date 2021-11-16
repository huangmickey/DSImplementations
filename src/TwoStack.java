import java.util.Arrays;

public class TwoStack {
    private int[] items;
    private int top1;
    private int top2;

    public TwoStack(int capacity) {
        items = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int item) {
        if (top1 + 1 == top2) throw new IllegalStateException();
        top1++;
        items[top1] = item;
    }

    public void push2(int item) {
        if (top2 - 1 == top1) throw new IllegalStateException();
        top2--;
        items[top2] = item;
    }

    public int pop1() {
        if (top1 == -1) throw new IllegalStateException();
        return items[top1--];
    }

    public int pop2() {
        if (top2 == items.length) throw new IllegalStateException();
        return items[top2++];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        TwoStack stack = new TwoStack(10);
        stack.push1(1);
        stack.push2(2);
        stack.push1(3);
        stack.push2(4);
        System.out.println(stack.pop1());
        System.out.println(stack.pop2());
        System.out.println(stack.pop2());
    }
}
