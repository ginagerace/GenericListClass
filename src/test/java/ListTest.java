import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {

	GenericStack<Integer> s;
	GenericStack<String> x;
	GenericStack<Float> f;

	GenericQueue<Integer> q;
	GenericQueue<String> r;
	GenericQueue<Float> t;

	@BeforeEach
	void init() {
		s = new GenericStack<Integer>(200);
		x = new GenericStack<String>("hello");
		f = new GenericStack<Float>(1.5f);

		q = new GenericQueue<Integer>(500);
		r = new GenericQueue<String>("miss");
		t = new GenericQueue<Float>(2.7f);
	}

	@Test
	void testInitGS(){
		assertEquals("GenericStack", s.getClass().getName(), "did not initialize proper object");
	}

	@Test
	void testInitGQ(){
		assertEquals("GenericQueue", q.getClass().getName(), "did not initialize proper object");
	}

	@Test
	void testInitNode(){
		assertEquals("GenericList$Node", s.head.getClass().getName(), "did not initialize node in constructor");
		assertEquals("GenericList$Node", q.head.getClass().getName(), "did not initialize node in constructor");
	}

	@Test
	void testStackForNodeVal(){
		assertEquals(200, s.head.data, "s- value not in node");
		assertEquals("hello", x.head.data, "x- value not in node");
		assertEquals(1.5f, f.head.data, "f- value not in node");
	}

	@Test
	void testQueueForNodeVal(){
		assertEquals(500, q.head.data, "s- value not in node");
		assertEquals("miss", r.head.data, "x- value not in node");
		assertEquals(2.7f, t.head.data, "f- value not in node");
	}

	//failed
	@Test
	void testStackPopListVal(){
		assertEquals(200, s.pop(), "s- value not returned");
		assertEquals("hello", x.pop(), "x- value not returned");
		assertEquals(1.5f, f.pop(), "f- value not returned");
	}

	@Test
	void testQueuePopListVal(){
		assertEquals(500, q.dequeue(), "s- value not returned");
		assertEquals("miss", r.dequeue(), "x- value not returned");
		assertEquals(2.7f, t.dequeue(), "f- value not returned");
	}

	//Failed
	@Test
	void testStackEmptyInt(){
		s.pop();
		assertEquals(null, s.head, "head not null");
		s.push(50);
		assertEquals(50, s.head.data, "value not in node");
		assertNull(s.head.next);
		assertEquals(1, s.getLength(), "did not get correct length");
	}

	@Test
	void testQueueEmptyListInt(){
		q.dequeue();
		assertEquals(null, q.head, "head not null");
		q.enqueue(50);
		assertEquals(50, q.head.data, "value not in node");
		assertNull(q.head.next);
		assertEquals(1, q.getLength(), "did not get correct length");
	}

	//Failed
	@Test
	void testStackEmptyListString(){
		x.pop();
		assertNull(x.head);
		x.push("wumbo");
		assertEquals("wumbo", x.head.data, "value not in node");
		assertNull(x.head.next);
		assertEquals(1, x.getLength(), "did not get correct length");
	}

	//Failed
	@Test
	void testQueueEmptyListString(){
		r.dequeue();
		assertNull(r.head);
		r.enqueue("wumbo");
		assertEquals("wumbo", r.head.data, "value not in node");
		assertNull(r.head.next);
		assertEquals(1, r.getLength(), "did not get correct length");
	}

	@Test
	void testPushToEmptyStack(){
		s.push(5);
		assertEquals(5, s.head.data, "did not push value correctly");
		x.push("never");
		assertEquals("never", x.head.data, "did not push value correctly");
	}

	@Test
	void testPushToEmptyQueue(){
		q.enqueue(5);
		assertEquals(500, q.head.data, "did not push value correctly");
		assertEquals(5, q.head.next.data, "did not push value correctly");
		r.enqueue("never");
		assertEquals("miss", r.head.data, "did not push value correctly");
		assertEquals("never", r.head.next.data, "did not push value correctly");
	}

	@Test
	void StackTestLength(){
		assertEquals(1, s.getLength(), "s- did not get correct length");
		assertEquals(1, x.getLength(), "x- did not get correct length");
		s.push(4);
		assertEquals(2, s.getLength(), "s- did not get correct length");
	}

	@Test
	void QueueTestLength(){
		assertEquals(1, q.getLength(), "s- did not get correct length");
		q.enqueue(79);
		assertEquals(2, q.getLength(), "x- did not get correct length");
		q.enqueue(20);
		assertEquals(3, q.getLength(), "x- did not get correct length");
		q.dequeue();
		assertEquals(2, q.getLength(), "x- did not get correct length");
	}

	@Test
	void StackCheckOrder(){
		s.push(6);
		assertEquals(200, s.head.next.data, "order is not correct");
		assertEquals(6, s.head.data, "order is not correct");
		x.push("tim");
		assertEquals("hello", x.head.next.data, "order is not correct");
		assertEquals("tim", x.head.data, "order is not correct");
	}

	@Test
	void QueueCheckOrder(){
		q.enqueue(20);
		q.enqueue(44);
		q.enqueue(90);
		assertEquals(500, q.head.data, "order is not correct");
		assertEquals(20, q.head.next.data, "order is not correct");
		assertEquals(44, q.head.next.next.data, "order is not correct");
		assertEquals(90, q.head.next.next.next.data, "order is not correct");
		assertEquals(4, q.getLength(), "length is not correct");
	}

	//Failed
	@Test
	void testCheckOrder2(){
		s.push(6);
		s.push(19);
		s.push(4985);
		assertEquals(19, s.head.next.data, "order is not correct");
		assertEquals(4985, s.head.data, "order is not correct");
		assertEquals(4, s.getLength(), "did not get correct length");
		assertEquals(4985, s.pop(), "wrong value returned");
		assertEquals(3, s.getLength(), "did not get correct length");
	}

	//Failed
	@Test
	void testPopReturn(){
		s.push(6);
		assertEquals(6, s.pop(), "wrong value returned");
		assertEquals(null, s.head.next, "next should be null");
		assertEquals(200, s.pop(), "wrong value returned");
		assertEquals(null, s.head, "empty list, head should be null");
	}

	//Failed
	@Test
	void StackPopLength(){
		s.push(60);
		s.pop();
		assertEquals(1, s.getLength(), "did not get correct length");
		s.pop();
		assertEquals(0, s.getLength(), "did not get correct length");
	}

	@Test
	void QueuePopLength(){
		q.enqueue(49);
		q.enqueue(22);
		assertEquals(3, q.getLength(), "did not get correct length");
		q.dequeue();
		q.dequeue();
		assertEquals(1, q.getLength(), "did not get correct length");
		q.dequeue();
		assertEquals(0, q.getLength(), "did not get correct length");
	}

	@Test
	void testPrint(){
		s.pop();
		s.print();
		q.dequeue();
		q.enqueue(30);
		q.print();
		s.push(300);
		s.push(400);
		s.print();
	}

}
