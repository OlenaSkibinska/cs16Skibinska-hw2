package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImmutableLinkedListTest {


    @Test
    public void size() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(4));
        int expResult = 1;
        int actualResult = test1.size();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void add() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(2));

        ImmutableList test2 = test1.add(1);
        String expResult = "2, 1";
        assertEquals(expResult, test2.toString());

    }


    @Test
    public void addAll() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(3));
        String expResult = "3, 2, 1";
        ImmutableList test2 = test1.addAll(new Object[] { 2, 1});
        assertEquals(expResult, test2.toString());
    }


    @Test
    public void get() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(6));
        ImmutableList test2 = test1.addAll(0, new Object[] {5, 3, 1});
        Object i = test2.get(2);
        Integer expResult = 3;

        assertEquals(expResult, i);
    }

    @Test
    public void remove() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(2));
        ImmutableList test2 = test1.addAll(0, new Object[] {7, 6});
        ImmutableList answer = test2.remove(1);
        String expResult = "7, 7, 7, 2";

        assertEquals(expResult, answer.toString());
    }

    @Test
    public void set() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(6));
        ImmutableList test2 = test1.addAll(0, new Object[] {1, 2});
        ImmutableList answer = test2.set(2,7);
        String expResult = "1, 2, 7, 1, 6";

        assertEquals(expResult, answer.toString());
    }

    @Test
    public void indexOf() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(4));
        ImmutableList test2 = test1.addAll(new Object[] {2,3});
        int answer = test2.indexOf(2);
        int expResult = 1;

        assertEquals(expResult, answer);
    }

    @Test
    public void clear() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(6));
        ImmutableList test2 = test1.addAll(0, new Object[] {2,9});
        ImmutableList answer = test2.clear();
        ImmutableLinkedList expResult = new ImmutableLinkedList(new Node(null));

        assertEquals(answer.toString(), expResult.toString());
    }

    @Test
    public void isEmpty() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(2));
        boolean answer = test1.isEmpty();
        boolean expResult = false;

        assertEquals(expResult, answer);
    }

    @Test
    public void toArray() throws Exception {
        ImmutableLinkedList test1 = new ImmutableLinkedList(new Node(4));
        ImmutableList answer = test1.add(4);
        Object[] finalAns = answer.toArray();
        Object[] expResult = {4, 4};

        assertEquals(expResult, finalAns);
    }


}