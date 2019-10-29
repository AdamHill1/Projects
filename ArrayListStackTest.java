/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze;

import DataStructures.EmptyCollectionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @version 1.0
 * @author Adam
 */
public class ArrayListStackTest {
    
    

    /**
     * Test of push method, of class ArrayListStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object t = 1;
        Object t1 = 2;
        //add one object and then another to see if its add to the list
        ArrayListStack instance = new ArrayListStack();
        instance.push(t);
        assertEquals(instance.size(), 1);
        instance.push(t1);
        assertEquals(instance.size(), 2);
        
        
        
        
    }

    /**
     * Test of pop method, of class ArrayListStack.
     * @throws java.lang.Exception
     */
    @Test
    public void testPop() throws Exception {
        System.out.println("pop");
        ArrayListStack instance = new ArrayListStack();
        //test when an item is in the list
        Object expResult = 1;
        instance.push(expResult);
        Object result = instance.pop();
        assertEquals(expResult, result);
        //test when list is empty
        try {
            instance.pop();
        } catch (EmptyCollectionException e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
    }

    /**
     * Test of peek method, of class ArrayListStack.
     * @throws java.lang.Exception
     */
    @Test
    public void testPeek() throws Exception {
        System.out.println("peek");
        ArrayListStack instance = new ArrayListStack();
        //test when an item is in the list
        Object expResult = 1;
        instance.push(expResult);
        Object result = instance.peek();
        assertEquals(expResult, result);
        instance.pop();
        //test when list is empty
        try {
            instance.pop();
        } catch (EmptyCollectionException e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
    }

    /**
     * Test of isEmpty method, of class ArrayListStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        ArrayListStack instance = new ArrayListStack();
        //test when list is empty
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        //test when list has one item
        instance.push(1);
        result = instance.isEmpty();
        expResult = false;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of size method, of class ArrayListStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        ArrayListStack instance = new ArrayListStack();
        //test when the size is zero
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        //test when the size has increased
        instance.push(1);
        expResult = 1;
        result = instance.size();
        assertEquals(expResult, result);
    }
    
}
