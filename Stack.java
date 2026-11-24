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
        Node<E> newNode = new Node<E>(element);
        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
}
}
