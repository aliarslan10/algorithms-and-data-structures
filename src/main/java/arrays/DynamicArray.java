package arrays;

import java.util.Arrays;

public class DynamicArray {

    public static void main(String[] args) {
        Array<Integer> numbers = new Array<>();
        numbers.put(10);
        numbers.put(20);
        numbers.put(30);
        System.out.println("Array Item : " + numbers.get(0));
        System.out.println("Array Size : " + numbers.size);
        for (int i = 0; i < numbers.size; i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println("---------");

        Array<String> str = new Array<>();
        str.put("AAAA");
        str.put("BBB");
        str.put("CCC");
        System.out.println("Array Item : " + str.get(0));
        System.out.println("Array Size : " + str.size);
        for (int i = 0; i < str.size; i++) {
            System.out.println(str.get(i));
        }
    }
}

class Array<T> {
    Object[] array;
    int size;

    public Array() {
        size = 0;
        array = new Object[1];
    }

    public int getSize() {
        return array.length;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void put(Object object) {
        ensureCapacity(size + 1);
        array[size++] = object;
    }

    private void ensureCapacity(int size) {
        int currentSize = getSize();
        if (size > currentSize) {
            // reducing ArrayCopy operation to prevent overkill by x2
            int newSize = size * 2;
            if (newSize < size) newSize = size;
            array = Arrays.copyOf(array, newSize);
        }
    }
}