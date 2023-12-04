import java.util.Iterator;

public class IntList implements Iterable<Integer> {

    private class ListCell {
        int content;
        ListCell next;

        ListCell(int x, ListCell n) {
            this.content = x;
            this.next = n;
        }
    }

    public ListCell head;

    public IntList() {
        head = null;
    }

    public void addFirst(int x) {
        head = new ListCell(x, head);
    }

    public Integer getFirst() {
        if (head != null) {
            return head.content;
        }
        return null;
    }

    public boolean dropFirst() {
        if (head != null) {
            head = head.next;
            return true;
        }
        return false;
    }

    public void addLast(int x) {
        if (head == null) {
            head = new ListCell(x, null);
            return;
        }

        ListCell current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListCell(x, null);
    }

    public Integer getLast() {
        if (head == null) {
            return null;
        }

        ListCell current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.content;
    }

    public boolean dropLast() {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            head = null;
            return true;
        }

        ListCell current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return true;
    }

    public void remove(int x) {
        ListCell current = head;
        ListCell prev = null;

        while (current != null) {
            if (current.content == x) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    public boolean contains(int x) {
        ListCell current = head;
        while (current != null) {
            if (current.content == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        ListCell current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    boolean isEmpty() {
            return head == null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntListIterator();
    }

    class IntListIterator implements Iterator<Integer> {
        private ListCell current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                int value = current.content;
                current = current.next;
                return value;
            }
            return null;
        }
    }

    public void reverse() {
        ListCell prev = null;
        ListCell current = head;
        ListCell next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        ListCell current = head;
        while (current != null) {
            result.append(current.content);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }


}
