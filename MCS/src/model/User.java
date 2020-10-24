package model;

public class User{

    //Attributes

    private String userName;
    private String password;
    private int age;

    //Relationship
    
    private Category type;

    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.type = Category.NEWBIE; 

    }

    
    /** 
     * @return String
     */
    //Getters 

    public String getUserName() {
        return userName;
        }
    
    /** 
     * @return String
     */
    public String getPassword() {
        return password;
        }
    
    /** 
     * @return int
     */
    public int getAge() {
        return age;
         }
    
         
         /** 
          * @param userName
          */
         //Setters

    public void setUserName(String userName){
        this.userName = userName;
    }


    
    /** 
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

    
    /** 
     * @param age
     */
    public void setAge(int age){
        this.age = age;
    }

    
    /** 
     * @return String
     */
    public String toString(){
		return "****** User ******\n"+
		"UserName: "+ userName + "\n"+
		"Age: "+ age + "\n"+
		"Category: "+ type + "\n";
	}









}