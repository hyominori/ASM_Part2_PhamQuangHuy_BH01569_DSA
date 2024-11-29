package DataStructure;

public class Array {
    private int[] arr;

    public Array(int size) {
        arr = new int[size];
    }

    public int access(int index) {
        if (index >= 0 && index < arr.length) {
            return arr[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void insert(int index, int element) {
        if (index >= 0 && index <= arr.length) {
            int[] newArr = new int[arr.length + 1];
            for (int i = 0, j = 0; i < newArr.length; i++) {
                if (i == index) {
                    newArr[i] = element;
                } else {
                    newArr[i] = arr[j++];
                }
            }
            arr = newArr;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < arr.length) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0, j = 0; i < arr.length; i++) {
                if (i != index) {
                    newArr[j++] = arr[i];
                }
            }
            arr = newArr;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public int search(int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
