package model;

public class Public extends Playlist{
    public static final int CALIFICATION =5;

    //Attributes
    private double[] score= new double[CALIFICATION];


    //Constructor
    public Public(String name) {
        super(name);
        this.score = score;
    }
    public void setScore(double aScore){
        boolean out=false;
        for(int i=0; i<CALIFICATION && out!=true; i++){
            if(score[i]==0.0){
                score[i]=aScore;
                out=true;
            }
        }
    }
  
   public double scoreAverage(){
       double average=0;
       for(int i=0; i<CALIFICATION; i++){
           if(score[i] != 0.0){
               average+=score[i];
           }
       }
       return average/CALIFICATION;
   }
  

   @Override
    public String playlistToString(){
        String out = "";
        out ="********** Public Playlist **********\n"+
             "** Title: "+getName()+"\n"+
             "** Duration:"+ timeToFormat(updateDuration()) +"\n"+
             "** Genre:"+ changeGenrePlaylist(playlistAllGenre()) +"\n"+
             "** Calification: "+scoreAverage()+"\n"+
             "******************************\n";

            return out;
        }

}
