import java.util.Iterator;

public class GenericQueue<I> extends GenericList<I> implements CreateIterator {


    // Constructor
    public GenericQueue(I data)
        { super(data); }

    // add to the back of the list
    @Override
    public void add(I data) {
        Node<I> end = new Node<I>(data, null);         //create a new node

        //empty set
        if (head == null) {
            head = end;
            addLength();
            return;
        }
            Node<I> temp = head;                 //create a temp node to traverse the list
            while (temp.next != null)            //keep going until end of list is reached
                temp = temp.next;
            temp.next = end;                    //add new node to end of list
            addLength();                       //update length of the list
    }

    void enqueue(I data){
        add(data);                          //call the add method to enqueue to the back of the list
    }

    I dequeue(){
        return delete();                     //call delete method to dequeue the first value on the que
    }

    //is this right?
    @Override
    public Iterator<I> createIterator() {
        return new GLIterator(head);
    }

    //Iterator list = GenericQueue.createIterator();
    //GLIterator.theList = this.head;
    //while(list.hasNext()) {list.next();}... look at code on blackboard
    //garbage collector marks any nodes in the heap with no references to it for deletion
}
