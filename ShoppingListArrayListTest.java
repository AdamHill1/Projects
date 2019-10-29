package Project1_Fall2019;

import DataStructures.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @version Spring 2019
 * @author Paul Franklin, Kyle Kiefer
 */
public class ShoppingListArrayListTest {

    private final ShoppingListArrayList instance;

    /**
     * Initialize instance and entries
     */
    public ShoppingListArrayListTest() {
        instance = new ShoppingListArrayList();
    }

    /**
     * Test of add method, of class ShoppingArray.
     */
    @Test
    public void testAdd() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        Grocery entry3 = new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1);
        
        // Testing to see if items quantity increases
        
        instance.add(entry3);
        assertTrue(entry3.getQuantity() == 1);
        instance.add(entry3);
        assertTrue(entry3.getQuantity() == 2);

        
        // Testing to see if multiple entries can be added and if you remove one the others are
        // still there
        instance.add(entry1);
        instance.add(entry2);
        instance.add(entry3);
        assertTrue(instance.contains(entry1));
        assertTrue(instance.contains(entry2));
        assertTrue(instance.contains(entry3));
        instance.remove(entry3);
        assertTrue(instance.contains(entry1));
        assertTrue(instance.contains(entry2));
        assertFalse(instance.contains(entry3));
        instance.remove(entry1);
        assertTrue(instance.contains(entry2)); 
        assertFalse(instance.contains(entry1));
        assertFalse(instance.contains(entry3));
    }

    /**
     * Test of remove method, of class ShoppingArrayList.
     */
    @Test
    public void testRemove() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        Grocery entry3 = new Grocery("Lucky Charms", "Cereal", 7, 3.99f, 1);

        // Test element not found case
        assertFalse(instance.remove(entry1));

        instance.add(entry1);
        assertEquals(1, instance.size());
        assertTrue(instance.contains(entry1));

        instance.remove(entry1);

        // Test general case (size)
        assertEquals(0, instance.size());

        // Test general case (content)
        assertFalse(instance.contains(entry1));
        
        instance.add(entry1);
        instance.add(entry2);
        instance.add(entry3);
        
        // Test remove shifts elements
        // Before shift
        try {
            assertTrue(instance.find(0).equals(entry1));
            assertTrue(instance.find(1).equals(entry2));
            assertTrue(instance.find(2).equals(entry3));
        }
        catch (EmptyCollectionException e) {
            fail("Unexpected ECE - testRemove");
        }
        
        assertTrue(instance.remove(entry1));
        
        // After shift
        try {
            assertTrue(instance.find(0).equals(entry2));
            assertTrue(instance.find(1).equals(entry3));
        }
        catch (EmptyCollectionException e) {
            fail("Unexpected ECE - testRemove");
        }
        
        // Collection bounds changed
        try {
            instance.find(2);
            fail();
        }
        catch (IndexOutOfBoundsException | EmptyCollectionException e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }

    /**
     * Test of find method, of class ShoppingArrayList.
     */
    @Test
    public void testFind() {
        //test to see if it throws index out of bounds exception
        //used some of the code above to help do this method
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        instance.add(entry1);
        try {
            instance.find(2);
            fail();
        }
        catch (IndexOutOfBoundsException | EmptyCollectionException e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
        
        // Test to see if it throws EmptyCollectionException
        instance.remove(entry1);
        try {
            instance.find(2);
            fail();
        }
        catch (IndexOutOfBoundsException | EmptyCollectionException e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        // Test that it can find entry 1 and entry 2
        instance.add(entry1);
        instance.add(entry2);
        try {
        assertTrue(instance.find(0) == entry1);
        assertTrue(instance.find(1) == entry2);
        }
        catch (IndexOutOfBoundsException | EmptyCollectionException e) {
            assertTrue(e instanceof IndexOutOfBoundsException);
        }
    }

    /**
     * Test of indexOf method, of class ShoppingArrayList.
     */
    @Test
    public void testIndexOf() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        Grocery entry2 = new Grocery("Green Tea", "Tea", 6, 1.99f, 2);
        //Test to see if it cant find the index that it throws and exception
        try {
        instance.indexOf(entry2);
        }
        catch (ElementNotFoundException e) {
            assertTrue(e instanceof ElementNotFoundException);
        }
        
        //Testing to see if it can find the index of the add entries
        try {
        instance.add(entry1);
        instance.indexOf(entry1);
        instance.add(entry2);
        instance.indexOf(entry2);
        assertTrue(instance.indexOf(entry1) == 0);
        assertTrue(instance.indexOf(entry2) == 1);
        
        }
        catch (ElementNotFoundException e) {
            assertTrue(e instanceof ElementNotFoundException);
        }

    }

    /**
     * Test of contains method, of class ShoppingArrayList.
     */
    @Test
    public void testContains() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);

        // Test element does not exist case
        assertFalse(instance.contains(entry1));

        instance.add(entry1);

        // Test element exists case
        assertTrue(instance.contains(entry1));
    }

    /**
     * Test of size method, of class ShoppingArrayList.
     */
    @Test
    public void testSize() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        assertTrue(instance.size() == 0);
        instance.add(entry1);
        assertTrue(instance.size() == 1);

    }

    /**
     * Test of isEmpty method, of class ShoppingArrayList.
     */
    @Test
    public void testIsEmpty() {
        Grocery entry1 = new Grocery("Mayo", "Dressing / Mayo", 1, 2.99f, 1);
        assertTrue(instance.isEmpty());
        instance.add(entry1);
        assertFalse(instance.isEmpty());

    }

}
