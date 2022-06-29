/* Metadata {"endless":true, "BW": true, "knobs": false, "data": false, "interaction": false}*/
package art.studio;

import processing.core.PApplet;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

public class SL017 extends PApplet {
    int w = 1000;
    int h = 1000;
    ArrayList<ArrayList<Float>> coords;

    @Override
    public void settings() {
        size(w, h);
    }

    @Override
    public void setup() {
        colorMode(HSB, 360, 100, 100);
        noStroke();
        background(0,0,0);
     }

    @Override
    public void draw() {

        bang();
        noLoop();
    }

    private void bang(){
        float ox;
        float oy;
        float dx;
        float dy;
        ox=0;
        oy=700;
        dx=700;
        dy=0;
        float step = dx/7;
        float inc = 1/step;
        float x1=ox;
        float y1=oy;
        float x2;
        float y2;
        float t=0;
        float i=1;
        while(i<step){
            System.out.println(i);
            t = i * inc;
            x2 = (1 - t) * ox + (t * dx);
            y2 = (1 - t) * oy + (t * dy);
            noStroke();
            fill(50 + (i * 20), 100, 100);
            //ellipse(ox, oy, 5, 5);
            //ellipse(dx, dy, 5, 5);
            ellipse(x1, y1, 5, 5);
            ellipse(x2, y2, 5, 5);
            stroke(50 + (i * 20), 0, 100);
            strokeWeight(5*i);
            //line(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
            i=i+inc;
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = { "SL017" };
        SL017 mySketch = new SL017();
        PApplet.runSketch(processingArgs, mySketch);
    }

}
