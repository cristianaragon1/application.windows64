PImage pictureOfRecord;        //as member variable
  import ddf.minim.*;     //at the very top of your sketch
  Minim minim;        //as a member variable
  AudioPlayer song;      //as a member variable

void setup(){
pictureOfRecord= loadImage("record.png");   //in setup method 
  size(pictureOfRecord.width, pictureOfRecord.height);  
  minim = new Minim(this);    //in the setup method
  song = minim.loadFile("awesomeTrack.mp3", 512);//in the setup method

}
void rotateImage(PImage image, int amountToRotate) {
      translate(width/2, height/2);
      rotate(amountToRotate*TWO_PI/360);                              
      translate(-image.width/2, -image.height/2);
}
int imageAngle = 0;
void draw(){
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
