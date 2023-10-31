package com.rest.dao;

import com.rest.exception.MyException;
import com.rest.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> listUser = new ArrayList<>();

    private static int i = 0;
    static {
        listUser.add(new User( i++,"solmaz" , LocalDate.now().minusYears(30)));
        listUser.add(new User(i++ ,"Gular" , LocalDate.now().minusYears(40)));
        listUser.add(new User(i++ ,"Asif" , LocalDate.now().minusYears(23)));
        listUser.add(new User(i++ ,"Vasif" , LocalDate.now().minusYears(25)));
    }



    public List<User> getAllUsers(){
        return listUser;
    }

    public User getUser(int id){
        User result = listUser.stream()
                .filter(user -> user.getId().equals(id)).findAny().orElseThrow(()-> new MyException("user not found"));
        return result;
    }

    public void saveUser(User user){
        user.setId(i++);
        listUser.add(user);
    }
}
