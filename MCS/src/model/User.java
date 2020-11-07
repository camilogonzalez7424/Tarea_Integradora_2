package model;

public class User{

    //Attributes

    private String userName;
    private String password;
    private int age;
    private int shareSong;

    //Relationship
    
    private Category type;

    //Constructor

    /**
	 * Constructor method of the user class.
     * @param userName, type String.
     * @param password, type String.
     * @param age, type int.
	 */
    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.shareSong=shareSong;
        this.type = Category.NEWBIE; 

    }

     //Getters 

    public String getUserName() {
        return userName;
        }
    
    public String getPassword() {
        return password;
        }
    
    public int getAge() {
        return age;
         }
    
     //Setters

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getShareSong(){
       return shareSong;
    }

    public void setShareSong(int shareSong){
        this.shareSong = shareSong;
    }

    public Category getType() {
        return type;
    }

    public void setType(Category type) {
        this.type = type;
    }

    
    
    /** 
     * Method that converts a string to enumeration.
     * <b> pre: </b> the enumeration must exist.
     * @param type type String.
     * @return return UserType of type Category.
     */
    public Category convert(String type){
        Category myUserType = Category.valueOf(type);
        return myUserType;

    }
    /** 
     * This method is responsible for printing information
     * <b> pre: </b> they must enter the data.
     * @return a String with user information.
     */
    public String toString(){
		return "****** User ******\n"+
		"UserName: "+ userName + "\n"+
		"Age: "+ age + "\n"+
        "Category: "+ type + "\n"+
        "******************\n";
	}


}