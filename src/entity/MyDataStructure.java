package entity;

/**
 * This Data Structure follows the LIFO (Last-In-First-Out) principle
 *
 */
public class MyDataStructure<T> {
    private Element top;

    private class Element {
        T data;
        Element next;

        public Element(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyDataStructure() {
        this.top = null;
    }

    /**
     *
     * Adds new element to the end of the data structure
     */
    public void add(T data) {
        Element newElement = new Element(data);
        newElement.next = top;
        top = newElement;
    }

    /**
     * Deletes top element
     * @return deleted element
     */
    public T delete() throws MyDataStructureException {
        if (top == null) {
            throw new MyDataStructureException("There is no element to delete");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    /**
     * This method shows you the top element
     */
    public T get() throws MyDataStructureException {
        if (top == null) {
            throw new MyDataStructureException("This Data Structure does not contain any elements");
        }
        return top.data;
    }
}
