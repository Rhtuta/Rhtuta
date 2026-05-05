import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String,User> userMap = new HashMap<>();

    private User currentUser = null;

    public boolean registerUser(String username,String password,String fullName,String contact)
    {
        if(userMap.containsKey(username)){
            System.out.println("Username already exists, try another one");
            return false;
        }
        User user = new User(username,password,fullName,contact);
        userMap.put(username,user);
        System.out.println("Registration successful!");
        return true;
    }

    public boolean loginUser(String username, String password)
    {
        if(!userMap.containsKey(username)){
            System.out.println("No user found with this username!");
            return false;
        }
        User user = userMap.get(username);
        if (!user.getPassword().equals(password))
        {
            System.out.println("Incorrect password!");
            return false;
        }
        currentUser = user;
        System.out.println("login successful!, Welcome: "+currentUser.getFullName());
        return true;
    }

    public void logOutUser()
    {
        if (currentUser!=null){
            System.out.println("logged out! "+currentUser.getFullName());
        }
        currentUser = null;
    }

    public boolean isLoggedIn()
    {
        return currentUser!=null;
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

}
