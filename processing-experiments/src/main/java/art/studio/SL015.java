/* Metadata {"endless":true, "BW": true, "knobs": false, "data": false, "interaction": false}*/
package art.studio;

import processing.core.PApplet;
import java.util.ArrayList;

public class SL015 extends PApplet {
    int w = 1000;
    int h = 1000;
    int ghosts;//number of particles
    ArrayList<Float[]> busters;//coordinates of the particles
    int bill;//radius of the particles
    int murray;//number of rays

    @Override
    public void settings() {
        size(w, h);
    }

    @Override
    public void setup() {
        colorMode(HSB, 360, 100, 100);
        noStroke();
        ghosts = (int)random(7,17);
        busters = new ArrayList<>();
        bill=(int)random(7,17);
        murray=(int)random(77,117);
        for (int i=0; i<ghosts; i++){
            Float[] fire = {random(bill,w-bill),random(bill,h-bill)};
            busters.add(i, fire);
        }
    }

    @Override
    public void draw() {
        background(0, 0, 0);
        fill(0,0,100);
        particles();
        rays();
    }

    private void particles(){
        float john;// x to draw particles
        float baldessari;// y to draw particles
        for (int i=0; i<ghosts; i++){
            john = busters.get(i)[0];
            baldessari = busters.get(i)[1];
            ellipse(john, baldessari, bill, bill);
        }
    }

    private void rays(){
        stroke(0,0,100);
        int stockholm; //origin coordinates of the ray
        int rotterdam; //destination coordinates of the ray
        for (int i=0; i<murray; i++){
            stockholm = (int)random(ghosts);
            rotterdam = (int)random(ghosts);
            if (stockholm!=rotterdam){
                line(busters.get(stockholm)[0],busters.get(stockholm)[1],busters.get(rotterdam)[0],busters.get(rotterdam)[1]);
            }
        }

    }

    public static void main(String[] args) {
        String[] processingArgs = { "SL015" };
        SL015 mySketch = new SL015();
        PApplet.runSketch(processingArgs, mySketch);
    }

}
