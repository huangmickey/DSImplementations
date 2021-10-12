import java.util.Objects;

public class ArrayList {
    private int ptr = -1;
    private int size;
    private Integer[] arr;

    public ArrayList() {
        arr = new Integer[16];
    }

    public ArrayList(int size) {
        arr = new Integer[size];
    }

    public void add(Integer element) {
        if (isFull()) expandList();
        arr[++ptr] = element;
        size++;

    }

    public int indexOf(Integer element) {
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(element, arr[i])) return i;
        }
        return -1;
    }

    public void remove() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        arr[ptr--] = null;
        size--;
    }

    public int length() {
        return arr.length;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == arr.length;
    }

    private void expandList() {
        Integer[] biggerList = new Integer[this.arr.length * 2];
        for (int i = 0; i < this.arr.length; i++) {
            biggerList[i] = arr[i];
        }
        this.arr = biggerList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString();
    }
}
