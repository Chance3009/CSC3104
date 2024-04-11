package lab8;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ResizingArrayQueueTest {
	ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>();
	
	@Before
    public void setUp() throws Exception {
        queue = new ResizingArrayQueue<>();
    }
	
	@Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertFalse(queue.isEmpty());
        
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
	
	@Test
    public void testSize() {
        assertEquals(0, queue.size());

        queue.enqueue(99);
        queue.enqueue(88);
        queue.enqueue(77);
        assertEquals(3, queue.size());

        queue.dequeue();
        assertEquals(2, queue.size());
        
        queue.dequeue();
        assertEquals(1, queue.size());
        
        queue.dequeue();
        assertEquals(0, queue.size());
    }
	  
    @Test
    public void testEnqueue() {
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        
        assertEquals(1, (int) queue.peek());
        
        queue.enqueue(2);
        assertEquals(1, (int) queue.peek());
        assertTrue(queue.size() == 2);
    }

    @Test
    public void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertTrue(queue.size() == 2);

        assertEquals(1, (int) queue.dequeue());
        
        assertTrue(queue.size() == 1);

        assertEquals(2, (int) queue.dequeue());

        assertTrue(queue.isEmpty());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testDequeueEmptyQueue() {
        assertTrue(queue.isEmpty());
        queue.dequeue(); 
    }
    
    @Test
    public void testPeek() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, (int) queue.peek());
        
        queue.dequeue();
        assertEquals(2, (int) queue.peek());
    }

    @Test
    public void testIterator() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        int sum = 0;
        for (int item : queue) {
            sum += item;
        }
        assertEquals(6, sum);
    }
}
