package model;

public class Public extends Playlist{
    public static final int CALIFICATION =100; //Maximum number of grades.

    //Attributes
    private double[] score;


    //Constructor

    /**
     * Generic public playlist constructor.
     * @param name , name of the playlist.
     */
    public Public(String name) {
        super(name);
        score= new double[CALIFICATION];
    }

    /**
     * This method receives the score and saves it to the array. <br>
     * @param aScore , type double.
     */
    public void setScore(double aScore){
        boolean out=false;
        for(int i=0; i<CALIFICATION && out!=true; i++){
            if(score[i]==0.0){
                score[i]=aScore;
                out=true;
            }
        }
    }
  
    /**
     * This method calculates the grade point average. <br>
     * pre: 
     * @return double
     */
   public double scoreAverage(){
       double average=0;
       int people = 0;
       for(int i=0; i<CALIFICATION; i++){
           if(score[i] != 0.0){
               average+=score[i];
               people++;
           }
       }
       return average/people;
   }
  

   @Override
    public String playlistToString(){
        String out = "";
        out ="********** Public Playlist **********\n"+
             super.playlistToString()+"\n"+
             "** Calification: "+scoreAverage()+"\n"+
             "******************************\n";

            return out;
        }

}
