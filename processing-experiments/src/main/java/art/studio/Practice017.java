package art.studio;

import processing.core.PApplet;

//practice drawing bezier curves
public class Practice017  extends PApplet {
    int w = 1000;
    int h = 1000;
    float cx1;
    float cy1;
    float cx2;
    float cy2;
    int off;
    float hu;

    @Override
    public void settings() {
        size(w, h);
    }

    @Override
    public void setup() {
        colorMode(HSB,360,100,100);
        background(1,0,0); 
        cx1 = 10;
        cy1 = h-10;
        cx2 = w-10;
        cy2 = 10;
        hu=0;
        off = 10;
    }

    @Override
    public void draw() {
        noFill();
        stroke(hu,100,100);
        off = off+50;
        bezier(cx1, cy1, cx1+50, cy1-off, cx2-50, cy2+off, cx2, cy2);
        hu = hu + 7;
        fill(0,0,100);
        ellipse(cx1+50,cy1-off,10,10);
        ellipse(cx2-50,cy2+off,10,10);
        //noLoop();
    } 

    public static void main(String[] args) {
        String[] processingArgs = { "Practice017" };
        Practice017 mySketch = new Practice017();
        PApplet.runSketch(processingArgs, mySketch);
    }

}
