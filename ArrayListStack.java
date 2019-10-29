/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maze;

import DataStructures.EmptyCollectionException;
import DataStructures.StackADT;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Adam Hill
 * @param <T> Generic class with type T
 */
public class ArrayListStack<T> implements StackADT<T> {
    private ArrayList<T> a = new ArrayList<>();

    /**
     * Adds the passed generic parameter to the ArrayList
     * @param t generic type parameter being passed in
     */
    @Override
    public void push(T t) {
        a.add(t);
    }

    /**
     * Will show the last value entered and remove it from list
     * @return T generic type
     * @throws EmptyCollectionException If array list is empty
     */
    @Override
    public T pop() throws EmptyCollectionException {
        T temp;
        //gets the value and removes from the list then return the value
        if (!a.isEmpty()) {
            temp = a.get( a.size() - 1);
            a.remove(a.size() - 1);
        } else {
            throw new EmptyCollectionException("Error!! The list is empty!!");
        }
        return temp;
    }

    /**
     * Will get the last entered value
     * @return T generic type
     * @throws EmptyCollectionException If array list is empty
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (!a.isEmpty()) {
            return a.get(a.size() - 1);
        } else {
            throw new EmptyCollectionException("Error!! The list is empty!!");
        }
    }

    /**
     *Will tell if the array list is empty or not true if its empty
     * @return boolean type
     */
    @Override
    public boolean isEmpty() {
        return a.isEmpty();
    }

    /**
     * Tells the size of the array list
     * @return Integer type
     */
    @Override
    public int size() {
        return a.size();
    }
    
}
