package model;

public class Private extends Playlist{

    //Attributes
    private User myUser;

    //Constructor
    public Private(String name) {
        super(name);
        this.myUser = myUser;
    }

    //Getters and Setters

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    
}