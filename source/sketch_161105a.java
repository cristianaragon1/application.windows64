import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_161105a extends PApplet {

PImage pictureOfRecord;        //as member variable
       //at the very top of your sketch
  Minim minim;        //as a member variable
  AudioPlayer song;      //as a member variable

public void setup(){
pictureOfRecord= loadImage("record.png");   //in setup method 
  size(pictureOfRecord.width, pictureOfRecord.height);  
  minim = new Minim(this);    //in the setup method
  song = minim.loadFile("awesomeTrack.mp3", 512);//in the setup method

}
public void rotateImage(PImage image, int amountToRotate) {
      translate(width/2, height/2);
      rotate(amountToRotate*TWO_PI/360);                              
      translate(-image.width/2, -image.height/2);
}
int imageAngle = 0;
public void draw(){
if(mousePressed){
imageAngle=imageAngle+5; 
}
rotateImage(pictureOfRecord, imageAngle);

image(pictureOfRecord, 0, 0);//in draw method
if(mousePressed){
song.play();
}else{
 song.pause(); 
}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "sketch_161105a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
