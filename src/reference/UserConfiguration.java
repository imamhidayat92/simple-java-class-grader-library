package reference;

public class UserConfiguration {
    public int studentId;
    public String password;
    
    public String host;
    
    public UserConfiguration(int studentId, String password) {
        this.studentId = studentId;
        this.password = password;
        this.host = "http://muslihat.net/ap2/uts";
    }
    
    public UserConfiguration(int studentId, String password, String host) {
        this.studentId = studentId;
        this.password = password;
        this.host = host;
    }
}
