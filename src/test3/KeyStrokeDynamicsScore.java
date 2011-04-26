package test3;

import java.util.LinkedList;

/**
 * Class for computing keystroke dynamics similarity
 * @author Stefan Miklosovic
 * @version 1.0
 */
public class KeyStrokeDynamicsScore {

    /** final score of keystroke similarity */
    private float score;

    /**
     * method for setting score
     * @param prototype
     * @param dynamics
     * @param size
     */
    public void setDynamicsScore(LinkedList<Float> prototype, KeyStrokeDynamics[] dynamics, int size) {
        float[] deviations = new float[prototype.size()];
        for (int i = 0; i < prototype.size(); i++) {
            float _temp_deviation = 0;
            for (int j = 0; j < dynamics.length; j++ ) {
                _temp_deviation += Math.abs((float) dynamics[j].get(i) - prototype.get(i));
            }
            deviations[i] = _temp_deviation;
        }
        float _score = 0;
        for (int i = 0; i < prototype.size(); i++) {
            _score += Math.abs(dynamics[dynamics.length - 1].get(i) - prototype.get(i)) / deviations[i];
        }
        score = 100 - (_score / prototype.size())*100;
    }

    /**
     * method for getting score
     * @return score
     */
    public float getDynamicsScore() {
        return score;
    }
}
