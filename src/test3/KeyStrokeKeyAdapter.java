package test3;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

/**
 * The KeyStrokeKeyAdapter class for getting typed characters to linked list
 * @author Stefan Miklosovic
 * @version 1.0
 */
public class KeyStrokeKeyAdapter implements KeyListener {
    /** String for pressed keys */
    private String pressed;
    /** String for released keys */
    private String released;
    /** Linked list where times of pressed keys are going to be stored */
    private LinkedList<String> timePressed = new LinkedList<String>();
    /** Linked list where times of released keys are going to be stored */
    private LinkedList<String> timeReleased = new LinkedList<String>();
    /** Linked list where string, password, is going to be stored */
    private LinkedList<String> typed = new LinkedList<String>();


    /** getting of linked list of timestamps of pressed keys
     *
     * @return pressed-keys timestamps
     */
    public LinkedList<String> getPressed() {
        return timePressed;
    }

    /** getting of linked list of timestamps of released keys
     *
     * @return released-keys timestamps
     */
    public LinkedList<String> getReleased() {
        return timeReleased;
    }
    
    /** what to do when key is pressed
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        pressed = "" + e.getWhen();
        timePressed.add(pressed);
        typed.add(KeyEvent.getKeyText(e.getKeyCode()));
    }

    /** what to do when key is released
     *
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        released = "" + e.getWhen();
        timeReleased.add(released);
    }

    /** what to do when key is typed
     *
     * @param e
     */
    public void keyTyped(KeyEvent e) {
    }

    /** method for clearing of buffers */
    public void clearBuffers() {
        pressed = "";
        released = "";
        timePressed.clear();
        timeReleased.clear();
        typed.clear();
    }

    /** method for getting password
     *
     * @return password in string
     */
    public String getPass() {
        return typed.toString();
    }
}
