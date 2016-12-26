package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {


    @Test
    public void add() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList();
        ImmutableList test2 = test1.add(6);
        Object[] expected = {6};
        assertArrayEquals(expected, test2.toArray());
    }


    @Test
    public void addAll() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10});
        ImmutableList test2 = test1.addAll(new Object[] {1});
        Object[] expected = {3, 5, 10, 1};
        assertArrayEquals(expected, test2.toArray());
    }

    @Test
    public void get() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10, 1});
        int test2 = (int) test1.get(0);
        int expected = 3;
        assertEquals(expected, test2);
    }

    @Test
    public void remove() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10, 1});
        ImmutableList test2 = test1.remove(3);
        Object[] expected = {3, 5, 10};
        assertArrayEquals(expected, test2.toArray());

    }

    @Test
    public void set() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10, 1});
        ImmutableList test2 = test1.set(1, 6);
        Object[] expected = {3, 6, 10, 1};
        assertArrayEquals(expected, test2.toArray());
    }

    @Test
    public void indexOf() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10, 1});
        int test2 = test1.indexOf(1);
        int expected = 3;
        assertEquals(expected, test2);
    }

    @Test
    public void size() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10, 1});
        int test2 = test1.size();
        int expected = 4;
        assertEquals(expected, test2);
    }


    @Test
    public void isEmpty() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10, 1});
        boolean test2 = test1.isEmpty();
        boolean expected = false;
        assertEquals(expected, test2);
    }

    @Test
    public void toArray() throws Exception {
        ImmutableArrayList test1 = new ImmutableArrayList(new Object[] {3, 5, 10, 1});
        java.lang.Object[] test2 = test1.toArray();
        Object[] expected = {3, 5, 10, 1};
        assertArrayEquals(expected, test2);

    }

}