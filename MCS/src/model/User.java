package model;

public class User{

    //Atributes

    private String userName;
    private String password;
    private int age;

    //Relatinship
    
    private Category type;

    public User(String userName, String password, int age, String type){
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.type = Category.valueOf(type); //Arreglar esto

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









}