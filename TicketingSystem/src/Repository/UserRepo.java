package Repository;

import Enums.UserType;
import Model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravdhingra
 */
public class UserRepo {
    Map<String , User> usermap = new HashMap<>();

    public void save(){
        usermap.put("Tom",new User("Tom", UserType.EMPLOYEE));
        usermap.put("Sam",new User("Sam", UserType.EMPLOYEE));
        usermap.put("Harry",new User("Harry", UserType.SUPERVISOR));
    }

    public Map<String , User> getUser(){
        return usermap;
    }

}
