public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    private void resize() {
        int[] newItems = new int[count * 2];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public boolean isFull() {
        return items.length == count;
    }

    public void insert(int item) {
        if (isFull()) resize();
        items[count++] = item;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) throw new IllegalArgumentException();
    }

    public void insertAt(int item, int index) {
        if (isFull()) resize();
        checkIndex(index);

        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = item;
        count++;
    }

    public void removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < count; i++) items[i] = items[i + 1];
        count--;
    }

    public int indexOf(int item) {
        // O(n)
        for (int i = 0; i < count; i++) {
            if (items[i] == item) return i;
        }
        return -1;
    }

    public int max() {
        int max = 0;
        for (int n : items) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public Array intersect(Array other) {
        Array intersectArr = new Array(count);
        for (int item : items) {
            if (other.indexOf(item) >= 0) {
                intersectArr.insert(item);
            }
        }
        return intersectArr;
    }

    public void reverse() {

        for (int i = 0; i < count / 2; i++) {
            int temp = items[i];
            items[i] = items[count - i - 1];
            items[count - i - 1] = temp;
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println("index " + i + ": " + items[i]);
        }
    }

    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.print();

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(3);
        numbers.print();
        int index = numbers.indexOf(30);
        System.out.println(index);
        System.out.println(numbers.max());
        numbers.insert(60);
        numbers.insert(70);
        System.out.println();

        Array numbers2 = new Array(3);
        numbers2.insert(10);
        numbers2.insert(30);
        numbers2.insert(50);
        Array numbersIntersect = numbers.intersect(numbers2);
        numbersIntersect.print();
        System.out.println();

        numbers.reverse();
        numbers.print();

        System.out.println();
        numbers.insertAt(29, 2);
        numbers.print();
    }
}
