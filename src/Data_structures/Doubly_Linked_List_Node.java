package Data_structures;

public class Doubly_Linked_List_Node<E> {
    Doubly_Linked_List_Node<E> next;
    Doubly_Linked_List_Node<E> prev;
    E element;

    public Doubly_Linked_List_Node(E element){
        this.element = element;
        next = null;
        prev = null;
    }
    public E getElement(){
        return this.element;
    }
}
