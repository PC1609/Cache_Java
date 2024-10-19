package Data_structures;

public class Doubly_Linked_List <E> {
    Doubly_Linked_List_Node<E> dummyHead;
    Doubly_Linked_List_Node<E> dummyTail;

    public Doubly_Linked_List(){
        dummyHead = new Doubly_Linked_List_Node<>(null);
        dummyTail = new Doubly_Linked_List_Node<>(null);
        dummyHead.next=dummyTail;
        dummyTail.prev =dummyHead;
    }

    public void addNodeToLast( Doubly_Linked_List_Node<E> node){
        Doubly_Linked_List_Node tail_previous = dummyTail.prev;
        tail_previous.next=node;
        node.next = dummyTail;
        dummyTail.prev=node;
        node.prev= tail_previous;
    }

    public Doubly_Linked_List_Node<E> addElementToLast(E element){
        Doubly_Linked_List_Node<E> newNode = new Doubly_Linked_List_Node<>(element);
        addNodeToLast(newNode);
        return newNode;
    }

    public void removeNode( Doubly_Linked_List_Node<E> node){
        if (node!=null){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    public Doubly_Linked_List_Node<E> getLastNode(){
        return dummyTail.prev;
    }
    public Doubly_Linked_List_Node<E> getFirstNode(){
        return dummyHead.next;
    }

    public void removeFirstNode(){
        Doubly_Linked_List_Node<E> firstNode = this.getFirstNode();
        this.removeNode(firstNode);
    }

}
