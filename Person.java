/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_adam_hill;

/**
 *
 * @author Adam
 */
public abstract class Person {

    private String name;
    private String address;
    private int id;
    private static int nextID = 1;

    /**
     *Constructor
     * @param name
     * @param address
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        id = nextID;
        nextID++;
    }

    /**
     *returns the id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *return the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *returns the address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**sets the address
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
