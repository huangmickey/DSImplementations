import java.util.Arrays;
import java.util.LinkedList;

public class HashTableChaining {

    // HashTable
    // put(k, v)
    // get(k): v
    // remove(k)
    // k : int
    // v : String
    // Collisions: chaining (linked lists)
    // [LL , LL , LL , LL] = linked list array LinkedList<Entry>[]
    // Entry has two private fields k, v

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        var bucket = getOrCreateBucket(key);
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        bucket.add(new Entry(key, value));
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();

        return entries[index];
    }

    private Entry getEntry(int key) {
        LinkedList<Entry> bucket = entries[hash(key)];
        if (bucket != null) {
            for (Entry entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private int hash(int key) {
        return Math.abs(key) % entries.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Entry> bucket : entries) {
            if (bucket != null) {
                for (Entry entry : bucket) {
                    sb.append("[").append(entry.key).append(", ").append(entry.value).append("] ");
                }
            }
        }
        return sb.toString();
    }

    public String printBuckets() {
        return Arrays.toString(entries);
    }

    public static void main(String[] args) {
        HashTableChaining hashTable = new HashTableChaining();
        hashTable.put(1, "A");
        hashTable.put(2, "B");
        hashTable.put(3, "C");
        hashTable.put(4, "D");
        hashTable.put(5, "E");
        System.out.println(hashTable);
    }
}
