package model;

public class User{

    //Attributes

    private String userName;
    private String password;
    private int age;
    private int shareSong;

    //Relationship
    
    private Category type;

    public User(String userName, String password, int age){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.shareSong=shareSong;
        this.type = Category.NEWBIE; 

    }

    //actualiza la categoria de un usuario
   public void setCategory(int shareSong){
        if(shareSong>=3){
            this.type= Category.LITTLE_CONTRIBUTOR;
        }
        if(shareSong>=10){
            this.type= Category.MILD_CONTRIBUTOR;
        }

        if(shareSong>=30){
            this.type= Category.STAR_CONTRIBUTOR;
        }
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

    public int getShareSong(){
       return shareSong;
    }

    public void setShareSong(int shareSong){
        this.shareSong = shareSong;
    }

    
    /** 
     * @return String
     */
    public String toString(){
		return "****** User ******\n"+
		"UserName: "+ userName + "\n"+
		"Age: "+ age + "\n"+
        "Category: "+ type + "\n"+
        "******************\n";
	}









}