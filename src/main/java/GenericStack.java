import java.util.Iterator;

public class GenericStack<I> extends GenericList<I> implements CreateIterator {


    // Constructor
    public GenericStack(I data)
        { super(data); }

    // add to the front of the list
    @Override
    public void add(I data) {
        if(head == null){
            head = new Node<I>(data, null);
            addLength();
            return;
        }
        Node<I> temp = new Node<I>(data, head);             //create a new node
        head = temp;
        addLength();                                      //update the length
    }

    void push(I data){
        add(data);                          //call the add method to push to front of list
    }

    I pop(){
        return delete();
    }

    //is this right?
    @Override
    public Iterator<I> createIterator() {
        return new GLIterator(head);
    }
}
