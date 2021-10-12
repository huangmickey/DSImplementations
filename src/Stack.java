public class Stack {
    private int[] stackArr;
    int ptr;

    public Stack(int size) {
        stackArr = new int[size];
    }

    public void push(int num) {
        if (isFull()) throw new IndexOutOfBoundsException("Stack is full");
        stackArr[ptr++] = num;
    }

    public int pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException("Stack empty");
        return stackArr[ptr--];
    }

    public int peek() {
        return stackArr[ptr];
    }

    public boolean isEmpty() {
        return ptr == 0;
    }

    public boolean isFull() {
        return ptr == stackArr.length;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ptr - 1; i++) {
            sb.append(stackArr[i]).append(", ");
        }

        return sb.append(stackArr[ptr - 1]).append("]").toString();
    }

}
