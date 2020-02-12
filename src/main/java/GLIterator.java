import java.util.Iterator;

//class gets a reference to the head so it can iterate through the list
public class GLIterator<I> implements Iterator<I> {

    GenericList<I>.Node<I> theList;

    public GLIterator(GenericList<I>.Node<I> head) {
        theList = head;
    }

    // checks if the head is null or not
    public boolean hasNext(){
        if(theList == null)
            return false;
        return true;
    }

    //returns the data value stored in the head
    public I next(){
        I data = theList.data;
        //check if next is null?
        theList = theList.next;
        return data;
    }
}