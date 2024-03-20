package Zhang.week4;



public class UserData {
    private int Id;
    private String Username;
    private String Password;
    private String email;
    private String gender;
    private String birthday;

    public int getId(){
        return Id;
    }
    public void setId(int id){
        this.Id=Id;
    }
    public String getUsername(){
        return Username;
    }
    public void setUsername(String username){
        this.Username=Username;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String password){
        this.Password=Password;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String birthday){
        this.birthday=birthday;
    }
}
