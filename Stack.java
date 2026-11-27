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
        return removed;
    }

    /**
     * Returns an element from the top of the stack without removing it.
     * 
     * @return Returns an element from the top of the stack.
     */
    public E peek(){
        E toReturn = null;
        if(head == null){
            toReturn = null;;
        }else{
            toReturn = head.value;
        }
        return toReturn;
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

    /**
     * Empties the stack.
     */
    public void clear(){
        head = null;
    }

    /**
     * Returns the position of the input parameter in the stack and -1 if it is not in the stack. 
     * The element at the top of the stack is in position 1. If there are n elements in the stack, 
     * the element at the bottom of the stack is in position n.
     * 
     * @param obj The object that you are searching for in the stack.
     * @return Returns the position of obj, and -1 if it's not in the stack.
     */
    public int search(Object obj){
        int position = 0;
        boolean found = false;
        Node<E> finger = head;
        if(head.value.equals(obj)){
            position = 1;
            found = true;
        }else{
            while(!found && finger != null){
                if(finger.value.equals(obj)){
                    found = true;
                }
                position++;
                finger = finger.next;
            }
        }
        if(found == false){
            position = -1;
        }
        return position;
    }

    /**
     * Returns a String representing the contents of the stack, separated by a single space. 
     * There should be no leading or trailing spaces in the returned string. If the stack is empty, 
     * returns the empty string.
     * 
     * @returns A string representation of the contents of the stack.
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
