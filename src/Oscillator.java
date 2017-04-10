/* oscillation -> amp × sin(theta)
* theta could be: frame / period × 2Pi -> assembles a fraction of a whole circle based on frame and period
* -> could be simplified to a constant angular velocity e.g. angle += 0.01
*/

import processing.core.PApplet;

/**
 * Created by Vankog on 17.12.2016.
 * Oscillates an objects back and forth.
 */
public class Oscillator extends PApplet{
    private static final int SIZE_X = 640;
    private static final int SIZE_Y = 480;


    private float angle = 0;
    private float angVel = 0.01f;
    private float angAcc = 0;
    private float amp = SIZE_X / 2.0f;
    // private float period = 200;

    public static void main(String[] args){
        PApplet.main("Oscillator", args);
    }
    //setup screen
    public void settings() {
        size(SIZE_X, SIZE_Y);
    }

    public void mouseClicked() {
    }

    public void draw() {
        background(0);

        translate(width/ 2.0f, height/ 2.0f);
        stroke(255);
        fill(255);

        angAcc = 0.00f;
        angVel += angAcc;
        angle += angVel;

        // oscillation -> amp × sin(theta) -> theta could be: frame / period × 2Pi:
        //float x = amp * sin(frameCount/period * TWO_PI);
        // simplified theta:
        float x = amp * sin(angle);

        line(0, 0, x, 0);
        ellipse(x, 0, 10, 10);
    }
}
