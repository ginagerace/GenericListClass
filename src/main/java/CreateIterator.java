import java.util.Iterator;

public interface CreateIterator<I> {

    public abstract Iterator<I> createIterator();

}

//need to pass in the head of the generic list