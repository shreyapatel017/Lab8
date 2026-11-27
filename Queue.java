import java.util.NoSuchElementException;

/**
 * Implements a generic queue.
 * 
 * @author Shreya Patel
 * @version 11/26/2026
 */
public class Queue<E> implements QueueInterface<E>
{
    private class Node<E>
    {
        private E value;
        private Node<E> next;
        private Node<E> previous;

        public Node(E value, Node<E> next)
        {
            this.value = value;
            this.next = next;
            this.previous = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public Queue()
    {
        head = null;
        tail = null;
    }

    /**
     * Adds element to the end of the queue.
     * 
     * @param element Element to be added to the queue.
     */
    public void enqueue(E element){
        if(head == null){
            head = new Node<E>(element, null);
            tail = head;
        }else{
            tail.next = new Node<E>(element, null); 
            tail = tail.next;
        }
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * 
     * @return Returns the element at the front of the queue.
     */
    public E getFront(){
        E toReturn;
        if(head == null){
            toReturn = null;
        }else{
            toReturn = head.value;
        }
        return toReturn;
    }

    /**
     * Returns true if there are no elements in the queue and false otherwise.
     * 
     * @return Returns true if there are no elements in the queue.
     */
    public boolean isEmpty(){
        boolean empty = false;
        if(head == null){
            empty = true; 
        }
        return empty;
    }

    /**
     * Removes all elements from the queue.
     */
    public void clear(){
        head = null;
        tail = null;
    }

    /**
     * Removes and returns the element from the front of the queue.
     * 
     * @return Returns the element from the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E dequeue(){
        E removed = null;
        if(head == null){
            throw new NoSuchElementException();
        }else if(head.next == null){
            removed = head.value;
            head = null;
            tail = null;
        }else{
            removed = head.value;
            head = head.next;
        }
        return removed;
    }

    /**
     * Returns a String representation of the queue separated by a single space.
     * 
     * @return Returns the String representation of the queue.
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        Node<E> finger = head;

        if(head == null){
            return "";
        }else{
            s.append(finger.value);
            finger = finger.next;
            while(finger != null){
                s.append(" " + finger.value);
                finger = finger.next;
            }
            return s.toString();
        }
    }
}
