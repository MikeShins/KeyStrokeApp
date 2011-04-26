/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test3;
import java.util.LinkedList;
/**
 * Class for setting and getting prototype from array of keystrokes
 * @author Stefan Miklosovic
 * @version 1.0
 */
public class Prototype {

    /** variable for prototype*/
    private LinkedList<Float> prototype = new LinkedList<Float>();

    /**
     * method for setting prototype
     * @param dynamics
     * @param count
     */
    public void setPrototype(KeyStrokeDynamics[] dynamics, long count) {
        clearPrototype();
        float _temp = 0;
        for (int i = 0; i < dynamics[0].lengthFeaturesVector(); i++) {
            for (int j = 0; j < count; j++) {
                _temp += (long) dynamics[j].get(i);
            }
            prototype.add(i, _temp / count);
            _temp = 0;
        }
    }

    /**
     * method for getting prototype
     * @return prototype
     */
    public LinkedList<Float> getPrototype() {
        return prototype;
    }

    /**
     * method for printing of prototype
     */
    public void printPrototype() {
        for (int i = 0; i < prototype.size(); i++) {
            System.out.print(prototype.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * method for clearing of prototype
     */
    private void clearPrototype() {
        prototype.clear();
    }
}
