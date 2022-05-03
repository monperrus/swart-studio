package art.studio;

import processing.core.PApplet;
import java.util.Random;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;



public class Deps004 extends PApplet{
    //data from the dependency trees
    int deps_teku_only=103;//103 only in teku = 19*5 + 8
    int deps_besu_only=165;//165 only in besu = 19*8 + 13
    int deps_in_both=190;//190 in the intersection = 19*10
    //display on 19*25; use the mag variable as a zoom (magnifying) factor
    int col = 25;
    int row = 19;
    int mag = 50;

    int w = 25*mag;
    int h = 19*mag;
    float x;
    float y;

    @Override
    public void settings() {
        size(w, h);
    }

    @Override
    public void setup() {
        colorMode(HSB, 360, 100, 100);
        noStroke();
        x=0;
        y=0;
        background(45,0,0);
    }

    @Override
    public void draw() {
        draw_besu_contour();
        draw_teku_contour();
        //draw_besu_only();
        //draw_intersection();
        //draw_teku_only();
        draw_all_besu();
        draw_all_teku();
        noLoop();
        save("supply_chain_diversity.png");
    }

    // draw white line around the besu deps (the unique+intersection)
    private void draw_besu_contour(){
        strokeWeight(17);
        stroke(10, 0, 100);
        line(0, (row - 13) * mag, 0, row * mag);
        line(0, row * mag, 19 * mag, row * mag);
        line(19 * mag, row * mag, 19 * mag, 0);
        line(19 * mag, 0, mag, 0);
        line(mag, 0, mag, (row - 13) * mag);
        line(mag, (row - 13) * mag, 0, (row - 13) * mag);
    }


    //on a 25*19 surface, the 165 deps of besu only are displayed as 13+8*19
    private void draw_besu_only(){
        noStroke();
        fill(60,100,100);
        //draw 13 dependencies at the bottom of the first column
        x=0;
        y=(row-13)*mag;
        for(int i=0;i<13;i++){
            rect(x+2,y+2,mag-4,mag-4);
            y=y+mag;
        }
        //draw 8*19
        x=0;
        y=0;
        for(int i=0;i<8;i++){
            x=x+mag;
            y=0;
            for(int j=0;j<row;j++){
                rect(x+2,y+2,mag-4,mag-4);
                y=y+mag;    
            }
        }
    }

    //on a 25*19 surface, the 165 deps of besu only are displayed as 13+8*19
    private void draw_all_besu(){
        noStroke();
        fill(60,100,100,200);
        //draw 13 dependencies at the bottom of the first column
        x=0;
        y=(row-13)*mag;
        for(int i=0;i<13;i++){
            rect(x+2,y+2,mag-4,mag-4);
            y=y+mag;
        }
        //draw 8*19
        x=0;
        y=0;
        for(int i=0;i<8+10;i++){
            x=x+mag;
            y=0;
            for(int j=0;j<row;j++){
                rect(x+2,y+2,mag-4,mag-4);
                y=y+mag;    
            }
        }
    }

        // draw white line around the besu deps (the unique+intersection)
        private void draw_teku_contour(){
            strokeWeight(17);
            stroke(0, 100, 100);
            line(9*mag, 0, 9* mag, row * mag);
            line(9* mag, row * mag,24*mag,row*mag);
            line(24*mag,row*mag,24*mag,8*mag);
            line(24*mag,8*mag,25*mag,8*mag);
            line(25*mag,8*mag,25*mag,0);
            line(25*mag,0,9*mag,0);
        }
    
    private void draw_intersection(){
        x=8*mag;
        y=0;
        noStroke();
        fill(80,100,100);
        for(int i=0;i<10;i++){
            x=x+mag;
            y=0;
            for(int j=0;j<row;j++){
                rect(x+2,y+2,mag-4,mag-4);
                y=y+mag;    
            }
        }

    }

    //on a 25*19 surface, the 103 deps of besu only are displayed as 8+5*19
    private void draw_teku_only(){
        noStroke();
        fill(100,100,100);
        //draw 8*19
        x=18*mag;
        y=0;
        for(int i=0;i<5;i++){
            x=x+mag;
            y=0;
            for(int j=0;j<row;j++){
                rect(x+2,y+2,mag-4,mag-4);
                y=y+mag;    
            }
        }
        //draw 13 dependencies at the bottom of the first column
        x=x+mag;
        y=0;
        for(int i=0;i<8;i++){
            rect(x+2,y+2,mag-4,mag-4);draw_all_besu();
            y=y+mag;
        }
    }
    //on a 25*19 surface, the 103 deps of besu only are displayed as 8+5*19
    private void draw_all_teku(){
        noStroke();
        fill(140,100,100,200);
        //draw 8*19
        x=8*mag;
        y=0;
        for(int i=0;i<5+10;i++){
            x=x+mag;
            y=0;
            for(int j=0;j<row;j++){
                rect(x+2,y+2,mag-4,mag-4);
                y=y+mag;    
            }
        }
        //draw 13 dependencies at the bottom of the first column
        x=x+mag;
        y=0;
        for(int i=0;i<8;i++){
            rect(x+2,y+2,mag-4,mag-4);
            y=y+mag;
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = { "Intersection of Besu and Teku Dependency trees"};
        Deps004 mySketch = new Deps004();
        PApplet.runSketch(processingArgs, mySketch);
    }

    
}
