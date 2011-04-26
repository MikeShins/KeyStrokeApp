package test3;

import java.util.LinkedList;

/**
 * The KeyStrokeKeyDynamics class for computation of similarity of typed keystrokes
 * @author Stefan Miklosovic
 * @version 1.0
 */
public class KeyStrokeDynamics {
    /** storage of pressed timestamps */
    private LinkedList<String> list1;
    /** storage of released timestamps */
    private LinkedList<String> list2;
    /** features vector */
    private LinkedList<Long> featuresVector = new LinkedList<Long>();

    /** Constructor - default threshold is 0.9
     * @param list1 pressed timestamps
     * @param list2 released timestamps
     */
    public void setKeyStrokes(LinkedList<String> list1, LinkedList<String> list2) {
        this.list1 = list1;
        this.list2 = list2;
        featuresVector.clear();
    }

    public void clearKeyStrokes() {
        list1.clear();
        list2.clear();
    }

    public void setFeaturesVector() {
        // list1 - pressed
        // list2 - released
        featuresVector.clear();
        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size() - 1; i++) {
                featuresVector.add(Long.parseLong(list2.get(i)) - Long.parseLong(list1.get(i)));
                featuresVector.add(Long.parseLong(list1.get(i+1)) - Long.parseLong(list2.get(i)));
            }
            featuresVector.add(Long.parseLong(list2.getLast()) - Long.parseLong(list1.getLast()));
        }
    }
    
    public void printFeaturesVector() {
        for (int i = 0; i < featuresVector.size(); i++) {
            System.out.print(featuresVector.get(i) + " ");
        }
        System.out.println("");
    }

    public int length() {
        return list1.size();
    }

    public int lengthFeaturesVector() {
        return featuresVector.size();
    }

    public Long get(int i) {
            return featuresVector.get(i);
    }
}
