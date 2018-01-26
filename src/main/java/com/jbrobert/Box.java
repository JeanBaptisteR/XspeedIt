package com.jbrobert;

import java.util.ArrayList;

/**
 *
 * This class represents a box used to package items
 *
 * @author Jean-Baptiste Robert
 */
public class Box {

    /**
     * List of items in the box
     */
    private ArrayList<Integer> items;

    /**
     * Size of the box
     */
    private static final int MAX_SIZE = 10;

    /**
     * Current size of the box
     */
    private int currentSize;

    public Box() {
        this.items = new ArrayList<Integer>();
        this.currentSize = 0;
    }

    /**
     * Add an item into the box
     *
     * @param item The item to add
     * @return True if the item can be added into the box. False otherwise
     */
    public boolean addItem(Integer item) {
        if (currentSize + item <= MAX_SIZE) {
            items.add(item);
            this.currentSize += item;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print the content of the box
     *
     * @return A String object representing the content of the box
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer item : items) {
            stringBuilder.append(item.toString());
        }
        return stringBuilder.toString();
    }
}
