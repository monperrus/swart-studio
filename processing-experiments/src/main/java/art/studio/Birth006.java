/* Metadata {"endless":false, "BW": false, "knobs": "false", "data": false, "interaction": false}*/
package art.studio;

import java.util.Random;
import java.util.ArrayList;
import processing.core.PApplet;

public class Birth006 extends PApplet {
    int w = 1000;
    int h = 1000;
    int[] palettef = { 0, 20, 40, 60, 80 };
    int lou = 69;
    float x;
    float y;
    float wid;
    int hu;
    int force; // to set the saturation of HSB colors
    int ciel; // to set the brightness of HSB colors
    int constellations; // count the number of constellations
    int rays; // count the number of rays
    Random rd;
    ArrayList<Float[]> stervilin;

    @Override
    public void settings() {
        size(w, h);
    }

    @Override
    public void setup() {
        colorMode(HSB, 360, 100, 100);
        x = 0;
        y = 0;
        wid = lou;
        constellations = 0;
        rays = 0;
        background(42, 42, 84);
        rd = new Random();
        stervilin = new ArrayList<>();
        init();
    }

    @Override
    public void draw() {
        if (constellations < stervilin.size()-1){
            point();
            constellations++;        
        }
        else{
            noLoop();
        }
    }

    private void init(){
        int step = lou*2;
        float x = step;
        float y = step;
        while (x<w){
            while (y<h){
                Float[] sunshine = new Float[2];
                sunshine[0]=random(x-step,x);
                sunshine[1]=random(y-step,y);
                stervilin.add(sunshine);
                y=y+step;
            }
            y=step;
            x=x+step;
        }
    }

    private void point(){
        hu=palettef[rd.nextInt(palettef.length-1)];
        fill(hu,100,100);
        noStroke();
        ellipse(stervilin.get(constellations)[0],stervilin.get(constellations)[1],10,10);
    }

    public static void main(String[] args) {
        String[] processingArgs = { "Birth006 " };
        Birth006 mySketch = new Birth006();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
