import java.util.EmptyStackException;

/**
 * Implements a generic stack.  
 * 
 * @author Shreya Patel
 * @version 11/23/2026
 */
public class Stack<E> implements StackInterface<E>
{
    private class Node<E>
    {
        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next)
        {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;

    public Stack()
    {
        head = null;
    }

    //add the required methods here
    /**
     * Adds an element to the top of the stack.
     * 
     * @param element Element to be added to the stack.
     */
    public void push(E element){
        head = new Node<E>(element, head);
    }

    /**
     * Removes and returns an element from the top of the stack.
     * 
     * @return Returns the removed element.
     * @throws EmptyStackException if stack is empty.
     */
    public E pop(){
        E removed = null;
        if(head == null){
            throw new EmptyStackException();
        }else if(head.next == null){
            removed = head.value;
            head = null;
        }else{
            removed = head.value;
            head = head.next;
        }
    }

    /**
     * Returns an element from the top of the stack without removing it.
     * 
     * @return Returns an element from the top of the stack.
     */
    public E peek(){
        if(head == null){
            throw new EmptyStackException();
        }else{
            return head.value;
        }
    }

    /**
     * Returns true if the stack is empty, and false otherwise.
     * 
     * @return Returns true if the stack is empty, false otherwise.
     */
    public boolean isEmpty(){
        boolean isEmpty = false;
        if(head == null){
            isEmpty = true; 
        }
        return isEmpty;
    }
}
