package com.jbrobert;

import java.util.*;

/**
 *
 * This class represents the process of packaging items into boxes trying to maximise the number of items per box
 *
 * @author Jean-Baptiste Robert
 */
public class Packager {

    private static final String SEPARATOR = "/";

    /**
     * Package items into boxes. Iterate over boxes and try to put the item into the first box where the item can fit.
     *
     * @param items List of items to package
     * @return List of boxes filled
     */
    private List<Box> packageItems(List<Integer> items) {
        List<Box> boxes = new ArrayList<Box>();

        if(items.size() > 0)
            boxes.add(new Box());

        for (Integer item : items) {
            // Put the item into the first box where the item can be put
            boolean addItem = false;
            int currentBox = 0;

            while (!addItem) {
                if (currentBox == boxes.size()) {
                    // Item can't be put in an existing box.
                    // Put it in a new box
                    Box newBox = new Box();
                    newBox.addItem(item);
                    boxes.add(newBox);
                    addItem = true;
                } else if (boxes.get(currentBox).addItem(item)) {
                    addItem = true;
                } else {
                    currentBox++;
                }
            }
        }
        return boxes;
    }

    /**
     * Same as 'packageItems' except that the items are sorted decreasingly to optimize the packaging
     *
     * @param items List of items to package
     * @return List of boxes filled
     */
    public List<Box> optimizedItemPackaging(List<Integer> items) {
        Collections.sort(items, Collections.reverseOrder());
        return packageItems(items);
    }

    /**
     * Print the boxes, their content and the total number of boxes used to package the items
     *
     * @param boxes List of boxes filled
     */
    public void printResult(List<Box> boxes) {
        StringBuilder result = new StringBuilder("Résultat : ");
        String prefix = "";
        for(Box box : boxes) {
            result.append(prefix);
            prefix = SEPARATOR;
            result.append(box.toString());
        }
        result.append(" ")
                .append("=> ")
                .append(boxes.size())
                .append(" cartons utilisés");
        System.out.println(result);
    }

    /**
     * Convert input into a list of integers
     *
     * @param input String representing the user's input
     * @return A list of items
     */
    public List<Integer> convertInputToItems(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for(String s : input.split("")) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

}
