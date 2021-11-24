package datastructures;

public class HashMapLinearProbing {

    // - put(int, String)
    // - get(int)
    // - remove(int)
    // - size()


    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries = new Entry[5];
    private int count;

    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) entry.value = value;
        if (isFull()) throw new IllegalStateException();
        entries[getIndex(key)] = new Entry(key, value);
        count++;
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (index == -1 || entries[index] == null) return;
        entries[index] = null;
        count--;
    }

    private boolean isFull() {
        return count == entries.length;
    }

    private Entry getEntry(int key) {
        return entries[getIndex(key)];
    }

    private int getIndex(int key) {
        int steps = 0;

        while (steps < entries.length) {
            int index = index(key, steps++);
            var entry = entries[index];
            if (entry == null || entry.key == key)
                return index;
        }
        return -1;
    }


    private int index(int key, int i) {
        return (hash(key) + i) % entries.length;
    }


    private int hash(int key) {
        return key % entries.length;
    }

    public static void main(String[] args) {
        HashMapLinearProbing hashMap = new HashMapLinearProbing();
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(3, "C");
        hashMap.put(4, "D");
        hashMap.put(5, "E");
        System.out.println(hashMap.get(3));
        hashMap.remove(3);
        System.out.println(hashMap.get(3));
    }
}
