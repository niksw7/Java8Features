

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by enigma on 24/10/15.
 * This class intends to show the pain of writing code in java7 and how lambada functions of java8 come to rescue
 * Get me a list of people older than 35
 */
public class LambadaRelief {
    private static List<User> users;

    public static void main(String[] args) {
        List<User> oldUser;
        oldUser = painfulJava();
        printUser(oldUser);

        oldUser = friendlyJava();
        printUser(oldUser);
    }

    private static void printUser(List<User> users) {
        users.forEach(u-> System.out.println("name "+u.getName()));
    }

    static {
        users = new ArrayList<User>(){
            {
                add(new User("Bruce Wayne",33));
                add(new User("Clark Kent",30));
                add(new User("Tony Stark",38));
                add(new User("Peter Parker",39));
            }
        };
    }

    private static List<User> painfulJava() {
        List<User> oldUsers = new ArrayList<User>();
        for (User user:users){
            if(user.getAge() > 35){
                oldUsers.add(user);
            }
        }
        return oldUsers;
    }

    /**
     * Using Filters
     * @return List<User>
     */
    private static List<User> friendlyJava() {
        return users.stream().filter(user -> user.getAge() > 35).collect(Collectors.toList());

    }
}
