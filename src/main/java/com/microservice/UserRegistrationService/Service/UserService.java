package com.microservice.UserRegistrationService.Service;
import com.microservice.UserRegistrationService.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService
{
    private List<User> userList=new ArrayList<>();
    public void addUser(User user)
    {
       userList.add(user);

    }

    public List<User> getUsers()
    {
        return userList;

    }

    public User getUser(String firstname)
    {
        int index=-1;
        for (User user : userList) {
            if (user.getFirstname().equals(firstname)) {
                index++;
            }
        }
       return userList.get(index);
    }

  /*  public String getEmail(String firstname)
    {
        for (User user : userList) {
            if (user.getFirstname().equals(firstname)) {
                return user.getContact();
            }
        }
      return "";
    }*/
}
