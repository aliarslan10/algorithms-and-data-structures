package hashtable;

public class HashTableImplementation {

    public static void main(String[] args) {
        HashTable<String> hashTable = new HashTable<>(5);
        hashTable.put(20, "Ali");
        hashTable.put(15, "Arslan");
        hashTable.put(20, "Demo");
        System.out.println(hashTable.get(20));
        System.out.println(hashTable.get(15));
    }
}

class HashNode {
    int key;
    Object value;
    HashNode next;

    public HashNode() { next = null; }

    public HashNode(int key, Object value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public int getKey() { return this.key; }

    public Object getValue() { return this.value; }
}

class HashTable<T> {
    HashNode[] hashNodeArray;
    int size;

    public HashTable(int size) {
        this.size = size;
        hashNodeArray = new HashNode[size];
        for (int i=0; i < size; i++) {
            hashNodeArray[i] = new HashNode();
        }
    }

    int getHash(int key) { return key%size; }

    public void put(int key, Object value) {
        int hashIndex = getHash(key);
        HashNode hashNode = hashNodeArray[hashIndex];
        HashNode newNode = new HashNode(key, value);
        newNode.next = hashNode.next;
        hashNode.next = newNode;
    }

    public T get(int key) {
        T value = null;
        int hashIndex = getHash(key);
        HashNode hashNode = hashNodeArray[hashIndex];
        while (hashNode != null) {
            if (hashNode.getKey() == key) {
                value = (T) hashNode.getValue();
            }
            hashNode = hashNode.next;
        }
        return value;
    }
}
