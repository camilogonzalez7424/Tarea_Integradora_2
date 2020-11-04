package model;

public class Restricted extends Playlist{

    public static final int ACCESS= 5;

    //Attributes
    private User[] myUser1 = new User[ACCESS];

    //Constructor
    public Restricted(String name) {
        super(name);
        this.myUser1 = myUser1;
    }

   
    
}