import java.util.Arrays;

public class ArrayIntList {
    private int size;
    protected int[] nums;
    static final int DEFAULT_CAPACITY = 10;

    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayIntList(int capacity) {
        size = 0;
        nums = new int[capacity];
    }

    public void add(int value) {
        if (size >= nums.length) {
            nums = Arrays.copyOf(nums, nums.length * 2);
        }
        nums[size] = value;
        size++;
    }

    public void add(int index, int value) {
        for (int i = size; i > index; i--) {
            nums[i] = nums[i-1];
        }
        nums[index] = value;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[" + nums[0];
        for (int i = 1; i < size; i++) {
            str += ", " + nums[i];
        }
        str += "]";
        return str;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return nums[index];
    }

    public void set(int index, int value) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        nums[index] = value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        for (int i = index; i < size -1; i++) {
                nums[i] = nums[i + 1];
        }
        size--;
        nums[size] = 0;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (value == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        return this.indexOf(value) > -1;
    }

    public void addAll(int[] intList) {
        for (int i: intList) {
            add(i);
        }
    }

    public int binarySearch(int value) {
        int min = 0;
        int max = size - 1;
        int mid = max / 2;
        while (min <= max) {
            if (value == nums[mid]) {
                return mid;
            } else if (value > nums[mid]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            mid = (max + min) / 2;
        }
        return -(mid + 1);
    }

    public void sort() {
        Arrays.sort(nums,0, size);
    }
}
