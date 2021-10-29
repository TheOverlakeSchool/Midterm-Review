public class LinkedIntList {
    protected ListNode front;

    public void add(int value) {
        ListNode temp = new ListNode(value);
        if (front == null) {
            front = temp;
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public void add(int index, int value) {
        if (index == 0){
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }

    }

    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int remove() {
        int value = front.data;
        front = front.next;
        return value;
    }

    public int remove(int index) {
        if (index == 0) {
            return remove();
        }
        ListNode current = front;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        int value = current.next.data;
        current.next = current.next.next;
        return value;
    }

    public void addSorted(int value) {
        ListNode current = front;
        if (front == null || current.data > value) {
            front = new ListNode(value, front);
        } else {
            while (current.next != null && current.next.data < value) {
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }
    }

    public String toString() {
        String s = "[";
        if (front == null) {
            return s += "]";
        }
        ListNode current = front;
        while (current != null) {
            s += current.data;
            if (current.next != null) {
                s += ", ";
            }
            current = current.next;
        }
        return s + "]";

    }

}
