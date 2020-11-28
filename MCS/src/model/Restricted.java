package model;

public class Restricted extends Playlist{

    public static final int ACCESS= 5;

    //Relationship
    private User[] myUser1;

    //Constructor

    /**
     * Generic private playlist constructor.
     * @param name , name of the playlist.
     * @param myUser1 , name of the users.
     */
    public Restricted(String name, User[] myUser1) {
        super(name);
        this.myUser1 = myUser1;
    }


    public User[] getMyUser1() {
        return myUser1;
    }

    public void setMyUser1(User[] newUser1) {
       this.myUser1 = newUser1;
}
    
    /**
     * This method concatenates the names of the creator users. <br>
     * @return the names
     */
    public String myUsersName(){
        String names="";
        for(int i=0; i<ACCESS; i++){
            if(myUser1[i] != null){
                names+= myUser1[i].getUserName()+",";

            }

        }
        if(names.equals("") || names==null){
            names= "No se ha guardado nada";
        }
       return names;
    }

    @Override
    public String playlistToString(){
        String out = "";
        out ="********** Restricted Playlist **********\n"+
             super.playlistToString()+"\n"+
             "** User: "+myUsersName()+"\n"+
             "******************************\n";

            return out;
        }

       
   
    
}