abstract class GenericList<I>{
    // DATA FIELDS
    public
        Node<I> head;
    private
        int length;

    GenericList(I data){
        head = new Node<I>(data, null);
        length = 1;
    }
    // METHODS

    // prints the items of the list, one value per line.
    public void print(){
        //empty
        if(head == null)
            return;
        //singleton
        if(head.next == null){
            System.out.println(head.data);
            return;
        }
        //otherwise
        while(head.next != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    // update the length of the list, will be used in add and delete methods
    public void addLength() {length++; }

    public int getLength() {return length;}

    // adds the value to the list.
    public abstract void add(I data);

    // returns the first value of the list and deletes the node
    public I delete(){
        // empty set
        if (head == null)
            { return null; }
        I temp = head.data;
        head = head.next;
        length--;
        return temp;
    }

    // generic inner class
    public class Node<T>{
        T data;
        Node<T> next;

        Node(T d, Node<T> n){//constructor
            this.data = d;
            this.next = n;
        }
    }

}
