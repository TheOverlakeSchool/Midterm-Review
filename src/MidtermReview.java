import java.util.List;

public class MidtermReview {
    public static void main(String[] args) {

        // Recursion
        System.out.println(factorial(4));

        // LinkedLists
        LinkedIntListMR list = new LinkedIntListMR();
        List.of(1, 8, 19, 4, 17).forEach((i)->list.add(i));
        list.stutter();
        System.out.println(list);

        // Recursion and Binary Search
        ArrayIntListMR list2 = new ArrayIntListMR();
        List.of(-4,2,7,10,15,20,22,25,30,36,42,50,56,68,85,92,103).forEach((i)-> list2.add(i));
        System.out.println(list2.binarySearchR(42));
        System.out.println(list2.binarySearchR(-66));
    }


    /**
     * Accepts an integer parameter n and uses recursion to compute and return the value of n factorial (also known as
     * n!). Your method should throw an IllegalArgumentException if n is negative. Several calls and their return values
     * are shown below.
     *
     * Call	            Output
     * factorial(0);	1
     * factorial(1);	1
     * factorial(3);	6
     * factorial(5);	120
     * factorial(10);	3628800
     * factorial(-4);	IllegalArgumentException
     */
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static class LinkedIntListMR extends LinkedIntList {

        /**
         * Doubles the size of a list by replacing every integer in the list with two of that integer. For example, suppose
         * a variable list stores the following sequence of integers:
         *
         * [1, 8, 19, 4, 17]
         * After a call of list.stutter(), it should store the following sequence of integers:
         *
         * [1, 1, 8, 8, 19, 19, 4, 4, 17, 17]
         */
        public void stutter() {
            ListNode current = front;
            while (current != null) {
                current.next = new ListNode(current.data,current.next);
                current = current.next.next;
            }

        }
    }

    public static class ArrayIntListMR extends ArrayIntList {

        /**
         * Returns the index of an occurrence of target in a, or a negative number if the target is not found.
         * Precondition: elements of a are in sorted order
         */
        public int binarySearchR(int n) {
            return binarySearchR(n, 0, size() - 1);
        }

        public int binarySearchR(int n, int min, int max) {
            if (min > max) {
                return -(min + 1);
            }
            int mid = (min + max) / 2;
            if (nums[mid] > n) {
                binarySearchR(n, min, mid - 1);
            } else if(nums[mid] < n) {
                binarySearchR(n, mid + 1, max);
            } else {
                return mid;
            }
        }

    }
}